package com.nickolasfisher.propertyapp.repository;

import com.nickolasfisher.propertyapp.model.Property;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertyRepositoryTests {

    @Autowired
    PropertyRepository propertyRepository;

    @Test
    public void validateBeanLoads() {
        assertNotNull(propertyRepository);
    }

    @Test
    public void findById_doesntGetNonExistentProperty() {
        Optional<Property> shouldBeNull = propertyRepository.findById(-1);
        assertTrue(shouldBeNull.isEmpty());
    }

    @Test
    public void findById_getsRealProperty() {
        Optional<Property> shouldExist = propertyRepository.findById(1);

        Property firstProperty = shouldExist.get(); // throws exception if null

        assertIsMaplewoodProperty(firstProperty);
    }

    private void assertIsMaplewoodProperty(Property firstProperty) {
        assertEquals(1, firstProperty.getId());
        assertEquals("205 Maplewood Lane", firstProperty.getAddressLine1());
        assertNull(firstProperty.getAddressLine2());
        assertEquals(2000, firstProperty.getSqFootage());
        assertEquals(6000, firstProperty.getLotSize());
        assertEquals(350000L, firstProperty.getAskingPrice());
    }

    @Test
    public void findByZipCode_works() {
        List<Property> byZipCode = propertyRepository.findByZipCode(12345);

        assertEquals(2, byZipCode.size());
        Property mapleWoodProperty = byZipCode.stream()
                .filter(p -> p.getId() == 1)
                .findFirst()
                .orElseThrow(RuntimeException::new);
        assertIsMaplewoodProperty(mapleWoodProperty);
    }
}
