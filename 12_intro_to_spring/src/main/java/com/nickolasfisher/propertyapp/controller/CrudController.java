package com.nickolasfisher.propertyapp.controller;

import com.nickolasfisher.propertyapp.model.Property;
import com.nickolasfisher.propertyapp.repository.PropertyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/properties")
@RequiredArgsConstructor
public class CrudController {

    private final PropertyRepository propertyRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Property> getPropertyById(@PathVariable int id) {
        Optional<Property> optionalProperty = propertyRepository.findById(id);

        return optionalProperty
                .map(property -> new ResponseEntity<>(property, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Property>> getPropertyByZip(
            @RequestParam(value = "zipCode") int zipCode) {
        return new ResponseEntity<>(propertyRepository.findByZipCode(zipCode), HttpStatus.OK);
    }
}