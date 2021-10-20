/*CustomerInvoiceService.java
Service for the customerInvoice
Author: Emihle Menzo 218337035
Date: August 2021
 */

package za.ac.cput.service.orderDetail;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.orderDetail.CustomerInvoice;
import za.ac.cput.factory.orderDetail.CustomerInvoiceFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest

class CustomerInvoiceServiceTest {
    @Autowired
    private CustomerInvoiceService service;

    private static CustomerInvoice customerInvoice = CustomerInvoiceFactory.buildCustomerInvoice(250);



    @Test
    void create() {
        CustomerInvoice created = service.create(customerInvoice);
        System.out.println("Create: " + created);
    }

    @Test
    void read() {
        CustomerInvoice read = service.read(customerInvoice.getInvoiceDate());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void update() {
        CustomerInvoice old = service.read("d69fc922-9d6d-40a3-a495-1d69ee0e84a4");
        CustomerInvoice updated = new  CustomerInvoice.Builder().copy(old).build();
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
    void getAllCustomerInvoice() {
    }
}