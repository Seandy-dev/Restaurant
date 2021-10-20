package za.ac.cput.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.entity.staffDetail.Demographic;
import za.ac.cput.factory.staff.DemographicFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemographicControllerTest {
    private static Demographic demographic = DemographicFactory.createDemographic("Female", "1999/02/05");
    public static String SECURITY_USERNAME = "abc";
    public static String SECURITY_PASSWORD = "pass";
    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseUrl = "http://localhost:8080/demographic";

    @Test
    void a_create() {
        String url = baseUrl + "/create";
        ResponseEntity<Demographic> postResponse = restTemplate.postForEntity(url, demographic, Demographic.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
//        one error
        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        demographic = postResponse.getBody();
        System.out.println("Saved data: " + demographic);
        assertEquals(demographic.getBirthDate(), postResponse.getBody().getBirthDate());
    }

    @Test
    void b_read() {
        String url = baseUrl + "/read/" + demographic.getBirthDate();
        System.out.println("URL " + url);
        ResponseEntity<Demographic> response = restTemplate.getForEntity(url, Demographic.class);
        assertEquals(demographic.getBirthDate(), response.getBody().getBirthDate());
    }

    @Test
    void c_update() {
        Demographic updated = new Demographic.Builder().copy(demographic).build();
        String url = baseUrl + "/update";
        System.out.println("URL:" + url);
        System.out.println("Post data: " + updated);
        ResponseEntity<Demographic> response = restTemplate.postForEntity(url, updated, Demographic.class);
    }

    @Test
    void e_delete() {
        String url = baseUrl + "/delete" + demographic.getBirthDate();
        System.out.println("URL " + url);
       restTemplate.delete(url);

    }

    @Test
    void d_getAll() {
        String url = baseUrl + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate
//                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("show all");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}