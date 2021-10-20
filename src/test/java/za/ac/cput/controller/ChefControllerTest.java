package za.ac.cput.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.TestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.entity.staff.Chef;
import za.ac.cput.factory.staff.ChefFactory;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ChefControllerTest {
    private static Chef chef = ChefFactory.buildChef(2556,4);
    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseUrl = "http://localhost:8080/chef";

    @Test
    void a_create() {
        String url = baseUrl + "/create";
        ResponseEntity<Chef> postResponse = restTemplate.postForEntity(url, chef, Chef.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        chef = postResponse.getBody();
        System.out.println("Saved data: " + chef);
        assertEquals(chef.getEmployeeId(), postResponse.getBody().getEmployeeId());
    }

    @Test
    void b_read() {
        String url = baseUrl + "/read/" + chef.getEmployeeId();
        System.out.println("URL " + url);
        ResponseEntity<Chef> response = restTemplate.getForEntity(url, Chef.class);
        assertEquals(chef.getEmployeeId(), response.getBody().getEmployeeId());
    }

    @Test
    void c_update() {
        Chef updated = new Chef.Builder().copy(chef).salary(100).build();
        String url = baseUrl + "/update";
        System.out.println("URL:" + url);
        System.out.println("Post data: " + updated);
        ResponseEntity<Chef> response = restTemplate.postForEntity(url, updated, Chef.class);
    }

    @Test
    void e_delete() {
        String url = baseUrl + "/delete" + chef.getEmployeeId();
        System.out.println("URL " + url);
        restTemplate.delete(url);

    }

    @Test
    void d_getAll() {
        String url = baseUrl + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("show all");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}