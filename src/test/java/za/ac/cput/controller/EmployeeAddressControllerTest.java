package za.ac.cput.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.entity.staffDetail.EmployeeAddress;
import za.ac.cput.factory.staff.EmployeeAddressFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmployeeAddressControllerTest {
    private static EmployeeAddress employeeAddress = EmployeeAddressFactory.createEmployeeAddress("2425 Masemola road", "24MR");
    public static String SECURITY_USERNAME = "abc";
    public static String SECURITY_PASSWORD = "pass";
    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseUrl = "http://localhost:8080/employeeAddress";

    @Test
    void a_create() {
        String url = baseUrl + "/create";
        ResponseEntity<EmployeeAddress> postResponse = restTemplate.postForEntity(url, employeeAddress, EmployeeAddress.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
//        one error
        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        employeeAddress = postResponse.getBody();
        System.out.println("Saved data: " + employeeAddress);
        assertEquals(employeeAddress.getAddressId(), postResponse.getBody().getAddressId());
    }

    @Test
    void b_read() {
        String url = baseUrl + "/read/" + employeeAddress.getAddressId();
        System.out.println("URL " + url);
        ResponseEntity<EmployeeAddress> response = restTemplate.getForEntity(url, EmployeeAddress.class);
        assertEquals(employeeAddress.getAddressId(), response.getBody().getAddressId());
    }

    @Test
    void c_update() {
        EmployeeAddress updated = new EmployeeAddress.Builder().copy(employeeAddress).build();
        String url = baseUrl + "/update";
        System.out.println("URL:" + url);
        System.out.println("Post data: " + updated);
        ResponseEntity<EmployeeAddress> response = restTemplate.postForEntity(url, updated, EmployeeAddress.class);
    }

    @Test
    void e_delete() {
        String url = baseUrl + "/delete" + employeeAddress.getAddressId();
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