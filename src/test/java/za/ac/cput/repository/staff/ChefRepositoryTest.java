//package za.ac.cput.repository.staff;
//
///* ChefRepositoryTest.java
// Entity for chef Repository Test
// Author: Emihle Menzo 218337035
//*/
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import za.ac.cput.entity.staff.Chef;
//import za.ac.cput.factory.staff.ChefFactory;
//import za.ac.cput.repository.staff.ChefRepository;
//
//import java.util.Set;
//
//import static org.junit.jupiter.api.Assertions.*;
//@TestMethodOrder(MethodOrderer.MethodName.class)
//class ChefRepositoryTest {
//
//    private static Chef chef = ChefFactory.buildChef(2500,5);
//    private ChefRepository repository = ChefRepository.getRepository();
//
//    @Test
//    void a_create() {
//        Chef inserted = repository.create(chef);
//        assertEquals(inserted.getEmployeeId(), Chef.getEmployeeId());
//        System.out.println("Inserted: " + inserted);
//    }
//
//    @Test
//    void b_update() {
//        Chef updated = new Chef.Builder().copy(chef).salary(2500).build();
//        updated = repository.update(updated);
//        assertEquals(updated.getEmployeeId(), chef.getEmployeeId());
//        System.out.println("Updated: " + updated);
//    }
//
//    @Test
//    void d_read() {
//        Chef read = repository.read(chef.getEmployeeId());
//        assertNotNull(read);
//        System.out.println("Read: " + read);
//    }
//
//    @Test
//    void c_delete() {
//        repository.delete(Chef.getEmployeeId());
//    }
//
//    @Test
//    void e_getall() {
//        Set<Chef> chefs = repository.getall();
//        assertEquals(1, chefs.size());
//        System.out.println("Chef: " + chefs);
//    }
//}