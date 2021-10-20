package za.ac.cput.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import za.ac.cput.entity.orderDetail.OrderItem;
import za.ac.cput.factory.orderDetail.OrderItemFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Name : Devon Sherwyn May
 * Student number : 219168296
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OrderItemControllerTest {
    private static OrderItem orderitem= OrderItemFactory.createOrderItem(12);
    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8080/Order/home";

    @Test
    void create()
    {
        String url = baseURL +"/create";
        ResponseEntity<OrderItem> postResponse = restTemplate.postForEntity(url,orderitem,OrderItem.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        orderitem= postResponse.getBody();
        System.out.println("Saved data"+ orderitem);
        assertEquals(orderitem.getQuantity(),postResponse.getBody().getQuantity());

    }

    @Test
    void read()
    {
        String url = baseURL+"/read"+orderitem.getQuantity();
        System.out.println("URL: " + url);
        ResponseEntity<OrderItem>response = restTemplate.getForEntity(url,OrderItem.class);
        assertEquals(orderitem.getQuantity(),response.getBody().getQuantity());
    }

    @Test
    void update() {
        OrderItem updated = new OrderItem.Builder().copy(orderitem).setQuantity(20).build();
        String url = baseURL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post data " + updated);
        ResponseEntity<OrderItem> response = restTemplate.postForEntity(url, updated, OrderItem.class);
    }

    @Test
    void delete()
    {
        String url= baseURL +"/delete/"+orderitem.getQuantity();
        System.out.println("URL: "+url);
        restTemplate.delete(url);
    }
}