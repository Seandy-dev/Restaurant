package za.ac.cput.service.staff;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.staff.Waiter;
import za.ac.cput.factory.staff.WaiterFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class WaiterServiceTest {

    @Autowired
    private WaiterService service;

    private static Waiter waiter = WaiterFactory.buildWaiter(7.90, 1, 50);

    @Test
    void a_create() {
        Waiter created = service.create(waiter);
        System.out.println("Create: " + created);
    }

    @Test
    void c_update() {
        Waiter old = service.read("d69fc922-9d6d-40a3-a495-1d69ee0e84a4");
        Waiter updated = new Waiter.Builder().copy(old).hourlyWage(78).build();
        assertNotNull(service.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void b_read() {
        Waiter read = service.read(waiter.getEmployeeId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void e_delete() {
        boolean success = service.delete("");
        assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Test
    void d_getAll(){

    }
}