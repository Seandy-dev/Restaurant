package za.ac.cput.repository.staff.impl;
//
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import za.ac.cput.entity.staff.Employee;
//import za.ac.cput.factory.staff.EmployeeFactory;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@TestMethodOrder(MethodOrderer.MethodName.class)
//class EmployeeRepositoryTest {
//    private static EmployeeRepository repository = EmployeeRepository.getRepository();
//    private static Employee employee = EmployeeFactory.buildEmployee("452131","Chef", "Thina", "Mbiza");
//
//    @Test
//    void a_create(){
//        Employee created = repository.create(employee);
//        assertEquals(created.getId(), employee.getId());
//        System.out.println("Create: " + created);
//    }
//
//    @Test
//    void b_read(){
//        Employee read = repository.read(employee.getId());
//        assertNotNull(read);
//        System.out.println("Read: " + read);
//    }
//
//    @Test
//    void c_update(){
//        Employee updated = new Employee.Builder().copy(employee).setEmployeeNumber("452131").setPositionId("Chef").build();
//        assertNotNull(repository.update(updated));
//        System.out.println("Update: " + updated);
//    }
//
//    @Test
//    void e_delete(){
//        boolean success = repository.delete(employee.getId());
//        assertTrue(success);
//        System.out.println("Delete: " + success);
//    }
//
//    @Test
//    void d_getAll(){
//        System.out.println("Show All: ");
//        System.out.println(repository.getAll());
//    }
//}
