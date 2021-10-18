//package za.ac.cput.repository.orderDetail.impl;
///* TableRepositoryImplTest.java
// Entity for Table Repository Impl Test
// Author: Sindiswa Nomusa Mbhele (219279616)
//*/
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import za.ac.cput.entity.orderDetail.Table;
//import za.ac.cput.factory.orderDetail.TableFactory;
//import za.ac.cput.repository.orderDetail.TableRepository;
//
//import java.util.Set;
//
//import static org.junit.jupiter.api.Assertions.*;
////@TestMethodOrder(MethodOrderer.MethodName.class)
//class TableRepositoryImplTest {
//
//    private static Table table = TableFactory.buildTable(true);
//    private TableRepository repository = TableRepositoryImpl.getRepository();
//
//    @Test
//    void a_create() {
//        Table inserted = repository.create(table);
//        assertEquals(inserted.getOccupied(), table.getOccupied());
//        System.out.println("Inserted: " + inserted);
//    }
//
//    @Test
//    void b_update() {
//        Table updated = new Table.Builder().copy(table).occupied(false).build();
//        updated = repository.update(updated);
//        assertEquals(updated.getTableNumber(), table.getTableNumber());
//        System.out.println("Updated: " + updated);
//    }
//
//    @Test
//    void d_read() {
//        Table read = repository.read(table.getTableNumber());
//        assertNotNull(read);
//        System.out.println("Read: " + read);
//    }
//
//    @Test
//    void c_delete() {
//        repository.delete(table.getTableNumber());
//    }
//
//    @Test
//    void e_getall() {
//        Set<Table> tables = repository.getall();
//        assertEquals(1, tables.size());
//        System.out.println("Table: " + tables);
//    }
//}