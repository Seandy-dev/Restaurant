//package za.ac.cput.service.orderDetail.impl;
///* TableServiceImplTest.java
// Entity for Table Service Impl Test
// Author: Sindiswa Nomusa Mbhele (219279616)
//*/
//import org.junit.jupiter.api.Test;
//import za.ac.cput.entity.orderDetail.Table;
//import za.ac.cput.factory.orderDetail.TableFactory;
//import za.ac.cput.service.orderDetail.TableService;
//
//import java.util.Set;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class TableServiceImplTest {
//    private static Table table = TableFactory.buildTable(false);
//    private TableService service = TableServiceImpl.getService();
//
//    @Test
//    void a_create() {
//        Table inserted = service.create(table);
//        assertEquals(inserted.getTableNumber(), table.getTableNumber());
//        System.out.println("Inserted: " + inserted);
//    }
//
//    @Test
//    void b_update() {
//        Table updated = new Table.Builder().copy(table).occupied(true).build();
//        updated = service.update(updated);
//        assertEquals(updated.getTableNumber(), table.getTableNumber());
//        System.out.println("Updated: " + updated);
//    }
//
//    @Test
//    void d_read() {
//        Table read = service.read(table.getTableNumber());
//        assertNotNull(read);
//        System.out.println("Read: " + read);
//    }
//
//    @Test
//    void c_delete() {
//        service.delete(table.getTableNumber());
//    }
//
//    @Test
//    void e_getall() {
//        Set<Table> tables = service.getall();
//        assertEquals(1, tables.size());
//        System.out.println("Tables: " + tables);
//    }
//}