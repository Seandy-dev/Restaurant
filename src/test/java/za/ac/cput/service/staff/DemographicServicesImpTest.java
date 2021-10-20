package za.ac.cput.service.staff;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.staffDetail.Demographic;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class DemographicServicesImpTest {

    @Autowired
    private DemographicServicesImp service;
    private Demographic demographic;

    @Test
    void create() {
        Demographic created = service.create(demographic);
        System.out.println("Create: " + created);
    }

    @Test
    void update() {
        Demographic old = service.read("1999/02/05");
        Demographic updated = new Demographic.Builder().copy(old).setBirthDate("").build();
        assertNotNull(service.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void read() {
        Demographic read = service.read(demographic.getBirthDate());
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