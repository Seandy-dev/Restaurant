//package za.ac.cput.repository.orderDetail;
//
///* CustomerInvoiceRepositoryTest.java
// Entity for customerInvoice Repository Test
// Author: Emihle Menzo 218337035
//*/
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import za.ac.cput.entity.orderDetail.CustomerInvoice;
//import za.ac.cput.factory.orderDetail.CustomerInvoiceFactory;
//import za.ac.cput.repository.orderDetail.CustomerInvoiceRepository;
//
//import java.util.Set;
//
//import static org.junit.jupiter.api.Assertions.*;
//@TestMethodOrder(MethodOrderer.MethodName.class)
//class CustomerInvoiceRepositoryTest {
//
//    private static CustomerInvoice customerInvoice = CustomerInvoiceFactory.buildCustomerInvoice(250);
//    private CustomerInvoiceRepository repository = CustomerInvoiceRepository.getRepository();
//
//    @Test
//    void a_create() {
//        CustomerInvoice inserted = repository.create(customerInvoice);
//        assertEquals(inserted.getInvoiceDate(), CustomerInvoice.getInvoiceDate());
//        System.out.println("Inserted: " + inserted);
//    }
//
//    @Test
//    void b_update() {
//        CustomerInvoice updated = new CustomerInvoice.Builder().copy(customerInvoice).orderAmount(250).build();
//        updated = repository.update(updated);
//        assertEquals(updated.getInvoiceDate(), CustomerInvoice.getInvoiceDate());
//        System.out.println("Updated: " + updated);
//    }
//
//    @Test
//    void d_read() {
//        CustomerInvoice read = repository.read(customerInvoice.getInvoiceDate());
//        assertNotNull(read);
//        System.out.println("Read: " + read);
//    }
//
//    @Test
//    void c_delete() {
//        repository.delete(CustomerInvoice.getInvoiceDate());
//    }
//
//    @Test
//    void e_getall() {
//        Set<CustomerInvoice> customerInvoices = repository.getall();
//        assertEquals(1, customerInvoices.size());
//        System.out.println("CustomerInvoice: " + customerInvoices);
//    }
//}