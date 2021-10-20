package za.ac.cput.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import za.ac.cput.entity.orderDetail.Order;
import za.ac.cput.factory.orderDetail.OrderFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Name : Devon Sherwyn May
 * Student number : 219168296
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderControllerTest {
    private static Order order= OrderFactory.createOrder(12,20211018);
    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8080/Order/home";



    @Test
    void create()
    {
        String url = baseURL +"/create";
        ResponseEntity<Order> postResponse = restTemplate.postForEntity(url,order,Order.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        order= postResponse.getBody();
        System.out.println("Saved data"+ order);
        assertEquals(order.getOrderNumber(),postResponse.getBody().getOrderNumber());

    }

    @Test
    void read()
    {
        String url = baseURL+"/read"+order.getOrderNumber();
        System.out.println("URL: " + url);
        ResponseEntity<Order>response = restTemplate.getForEntity(url,Order.class);
        assertEquals(order.getOrderNumber(),response.getBody().getOrderNumber());
    }

    @Test
    void update() {
        Order updated = new Order.Builder().copy(order).setOrderNumber(20).setOrderDate(20211009).build();
        String url = baseURL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post data " + updated);
        ResponseEntity<Order> response = restTemplate.postForEntity(url, updated, Order.class);
    }

    @Test
    void delete()
    {
        String url= baseURL +"/delete/"+order.getOrderNumber();
        System.out.println("URL: "+url);
        restTemplate.delete(url);
    }
}