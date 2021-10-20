package za.ac.cput.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.entity.staff.Employee;
import za.ac.cput.factory.staff.EmployeeFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmployeeControllerTest {
    private static Employee employee = EmployeeFactory.buildEmployee("", "Chef", "Thina", "Mbiza");


    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseUrl = "http://localhost:8080/employee";
    
    @Test
    void a_create() {
        String url = baseUrl + "/create";
        ResponseEntity<Employee> postResponse = restTemplate.postForEntity(url, employee, Employee.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
//        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        employee = postResponse.getBody();
        System.out.println("Saved data: " + employee);
        assertEquals(employee.getEmployeeNumber(), postResponse.getBody().getEmployeeNumber());
    }

    @Test
    void b_read() {
        String url = baseUrl + "/update/"  + employee.getEmployeeNumber();
        System.out.println("URL " + url);
        ResponseEntity<Employee> response = restTemplate.getForEntity(url, Employee.class);
        assertEquals(employee.getEmployeeNumber(), response.getBody().getEmployeeNumber());
    }

    @Test
    void c_update() {
        Employee updated = new Employee.Builder().copy(employee).positionId("Hostess").build();
        String url = baseUrl + "/update";
        System.out.println("URL:" + url);
        System.out.println("Post data: " + updated);
        ResponseEntity<Employee> response = restTemplate.postForEntity(url, updated, Employee.class);
    }

    @Test
    void e_delete() {
        String url = baseUrl + "/delete" + employee.getEmployeeNumber();
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

