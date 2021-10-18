//package za.ac.cput.repository.staff.impl;
///* WaiterRepositoryImplTest.java
// Entity for Waiter Repository Impl Test
// Author: Sindiswa Nomusa Mbhele (219279616)
//*/
//import org.junit.jupiter.api.Test;
//import za.ac.cput.entity.staff.Waiter;
//import za.ac.cput.factory.staff.WaiterFactory;
//
//import java.util.Set;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class WaiterRepositoryImplTest {
//
//    private static Waiter waiter = WaiterFactory.buildWaiter(50.00, 1, 7.00);
//    private WaiterRepository repository = WaiterRepositoryImpl.getRepository();
//
//    @Test
//    void a_create() {
//        Waiter inserted = repository.create(waiter);
//        assertEquals(inserted.getEmployeeId(), waiter.getEmployeeId());
//        System.out.println("Inserted: " + inserted);
//    }
//
//    @Test
//    void b_update() {
//        Waiter updated = new Waiter.Builder().copy(waiter).hourlyWage(59.00).build();
//        updated = repository.update(updated);
//        assertEquals(updated.getEmployeeId(), waiter.getEmployeeId());
//        System.out.println("Updated: " + updated);
//    }
//
//    @Test
//    void c_read() {
//        Waiter read = repository.read(waiter.getEmployeeId());
//        assertNotNull(read);
//        System.out.println("Read: " + read);
//    }
//
//    @Test
//    void e_delete() {
//        repository.delete(waiter.getEmployeeId());
//    }
//
//    @Test
//    void d_getall() {
//        Set<Waiter> waiters = repository.getall();
//        assertEquals(1, waiters.size());
//        System.out.println("Chef: " + waiters);
//    }
//}