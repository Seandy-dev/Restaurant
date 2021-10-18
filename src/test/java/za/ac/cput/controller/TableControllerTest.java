package za.ac.cput.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.entity.orderDetail.Ta_ble;
import za.ac.cput.factory.orderDetail.TableFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TableControllerTest {
    private static Ta_ble table = TableFactory.buildTable(true);
    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseUrl = "http://localhost:8080/table";

    @Test
    void a_create() {
        String url = baseUrl + "/create";
        ResponseEntity<Ta_ble> postResponse = restTemplate.postForEntity(url, table, Ta_ble.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
//        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        table = postResponse.getBody();
        System.out.println("Saved data: " + table);
        assertEquals(table.getTableNumber(), postResponse.getBody().getTableNumber());
    }

    @Test
    void b_read() {
        String url = baseUrl + "/read/" + table.getTableNumber();
        System.out.println("URL " + url);
        ResponseEntity<Ta_ble> response = restTemplate.getForEntity(url, Ta_ble.class);
        assertEquals(table.getTableNumber(), response.getBody().getTableNumber());
    }

    @Test
    void c_update() {
        Ta_ble updated = new Ta_ble.Builder().copy(table).occupied(true).build();
        String url = baseUrl + "/update";
        System.out.println("URL:" + url);
        System.out.println("Post data: " + updated);
        ResponseEntity<Ta_ble> response = restTemplate.postForEntity(url, updated, Ta_ble.class);
    }

    @Test
    void e_delete() {
        String url = baseUrl + "/delete" + table.getOccupied();
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