package za.ac.cput.controller;

/*CustomerInvoice.java
Controller test for the CustomerInvoice
Author: Emihle Menzo 218337035
Date: August 2021
 */


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.TestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.entity.orderDetail.CustomerInvoice;
import za.ac.cput.factory.orderDetail.CustomerInvoiceFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class CustomerInvoiceControllerTest {
    private static CustomerInvoice customerInvoice = CustomerInvoiceFactory.buildCustomerInvoice(250);
    public static String SECURITY_USERNAME =  "abc";
    public static String SECURITY_PASSWORD = "pass";
    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseURL = "http://localhost:8080/customerInvoice";


    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<CustomerInvoice> postResponse = restTemplate.postForEntity(url, customerInvoice,CustomerInvoice.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        customerInvoice = postResponse.getBody();
        System.out.println("saved data: " + customerInvoice);
        assertEquals(customerInvoice.getInvoiceDate(), postResponse.getBody().getInvoiceDate());
    }

    @Test
    void b_read() {
        String url = baseURL + "/read" + customerInvoice.getInvoiceDate();
        System.out.println("URL: " + url);
        ResponseEntity<CustomerInvoice> response = restTemplate.getForEntity(url, CustomerInvoice.class);
        assertEquals(customerInvoice.getInvoiceDate(), response.getBody().getInvoiceDate());


    }

    @Test
    void a_update() {
        CustomerInvoice updated = new CustomerInvoice.Builder().copy(customerInvoice).build();
        String url = baseURL + "/update:";
        System.out.println("URL: " + url);
        System.out.println("post date: " + updated);
        ResponseEntity<CustomerInvoice> response = restTemplate.postForEntity(url, updated, CustomerInvoice.class);

    }

    @Test
    void d_delete() {
        String url = baseURL + "/delete/ " + customerInvoice.getInvoiceDate();
        System.out.println("URL: " + url);
        restTemplate.delete(url);

    }

    @Test
    void d_getAll(){
        String url = baseURL + "/getAll";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,entity,String.class);
        System.out.println("show all: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}