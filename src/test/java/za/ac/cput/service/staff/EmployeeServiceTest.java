package za.ac.cput.service.staff;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.staff.Employee;
import za.ac.cput.factory.staff.EmployeeFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class EmployeeServiceTest {
    @Autowired
    private static EmployeeService service;
    private static Employee employee = EmployeeFactory.buildEmployee("452131", "Chef", "Thina", "Mbiza");

    @Test
    void a_create(){
        Employee created = service.create(employee);
        assertEquals(created.getEmployeeNumber(), employee.getEmployeeNumber());
        System.out.println("Create: " + created);
    }

    @Test
    void b_read(){
        Employee read = service.read(employee.getEmployeeNumber());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void d_update(){
        Employee old = service.read("452131");
        Employee updated = new Employee.Builder().copy(old).positionId("Hostess").build();
        assertNotNull(service.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void c_delete(){
        boolean success = service.delete("");
        assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Test
    void e_getAll(){

    }
}