/*Chef.java
service test for the chef
Author: Emihle Menzo 218337035
Date: August 2021
 */
package za.ac.cput.service.staff;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import org.junit.jupiter.api.Test;

import za.ac.cput.entity.orderDetail.CustomerInvoice;
import za.ac.cput.entity.staff.Chef;
import za.ac.cput.factory.staff.ChefFactory;
import za.ac.cput.factory.orderDetail.CustomerInvoiceFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class ChefServiceTest {
    @Autowired
    private ChefService service;

    private static Chef chef = ChefFactory.buildChef(2500,5);



    @Test
    void create() {
        Chef created = service.create(chef);
        System.out.println("Create: " + created);
    }

    @Test
    void read() {
        Chef read = service.read(chef.getEmployeeId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void update() {
        Chef old = service.read("d69fc922-9d6d-40a3-a495-1d69ee0e84a4");
        Chef updated = new  Chef.Builder().copy(old).build();
        assertNotNull(service.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void delete() {
        boolean success = service.delete("");
        assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Test
    void getAllChef() {
    }
}