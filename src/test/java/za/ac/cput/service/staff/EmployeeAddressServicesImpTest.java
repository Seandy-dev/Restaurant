package za.ac.cput.service.staff;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.staffDetail.EmployeeAddress;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest

class EmployeeAddressServicesImpTest {
    @Autowired
    private EmployeeAddressServices service;
    private EmployeeAddress employeeAddress;


    @Test
    void create() {
        EmployeeAddress created = service.create(employeeAddress);
        System.out.println("Create: " + created);
    }

    @Test
    void update() {
        EmployeeAddress old = service.read("24MR");
        EmployeeAddress updated = new EmployeeAddress.Builder().copy(old).setAddressId("").build();
        assertNotNull(service.update(updated));
        System.out.println("Updated: " + updated);

    }

    @Test
    void read() {
        EmployeeAddress read = service.read(employeeAddress.getAddressId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void delete() {
        boolean success = service.delete("");
        assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Test
    void getAll() {
    }
}