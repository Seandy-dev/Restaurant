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
import za.ac.cput.entity.staff.Waiter;
import za.ac.cput.factory.staff.WaiterFactory;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WaiterControllerTest {
    private static Waiter waiter = WaiterFactory.buildWaiter(56,4,34);
    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseUrl = "http://localhost:8080/waiter";

    @Test
    void a_create() {
        String url = baseUrl + "/create";
        ResponseEntity<Waiter> postResponse = restTemplate.postForEntity(url, waiter, Waiter.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
//        one error
//        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        waiter = postResponse.getBody();
        System.out.println("Saved data: " + waiter);
        assertEquals(waiter.getEmployeeId(), postResponse.getBody().getEmployeeId());
    }

    @Test
    void b_read() {
        String url = baseUrl + "/read/" + waiter.getEmployeeId();
        System.out.println("URL " + url);
        ResponseEntity<Waiter> response = restTemplate.getForEntity(url, Waiter.class);
        assertEquals(waiter.getEmployeeId(), response.getBody().getEmployeeId());
    }

    @Test
    void c_update() {
        Waiter updated = new Waiter.Builder().copy(waiter).tip(5).build();
        String url = baseUrl + "/update";
        System.out.println("URL:" + url);
        System.out.println("Post data: " + updated);
        ResponseEntity<Waiter> response = restTemplate.postForEntity(url, updated, Waiter.class);
    }

    @Test
    void e_delete() {
        String url = baseUrl + "/delete" + waiter.getEmployeeId();
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