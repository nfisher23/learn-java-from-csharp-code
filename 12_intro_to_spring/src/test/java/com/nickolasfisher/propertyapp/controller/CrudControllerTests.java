package com.nickolasfisher.propertyapp.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CrudControllerTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void getsByPrimaryKey() throws Exception {
        String json = testRestTemplate.getForObject("http://localhost:" + port + "/properties/1", String.class);
        JsonNode jsonNode = objectMapper.readValue(json, JsonNode.class);
        assertEquals(jsonNode.get("addressLine1").asText(), "205 Maplewood Lane");
    }

    @Test
    public void primaryKeyDNE_404() {
        ResponseEntity<String> entity = testRestTemplate.getForEntity("http://localhost:" + port + "/properties/4", String.class);
        assertEquals(HttpStatus.NOT_FOUND, entity.getStatusCode());
    }

    @Test
    public void zipCodeGet_works() {
        JsonNode node = testRestTemplate.getForObject("http://localhost:" + port + "/properties?zipCode=12345", JsonNode.class);
        assertEquals(2, node.size());
    }
}
