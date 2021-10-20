package za.ac.cput.factory.orderDetail;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.orderDetail.CustomerInvoice;

import static org.junit.jupiter.api.Assertions.*;

class CustomerInvoiceFactoryTest {
    @Test
    public void buildCustomerInvoice() {
        CustomerInvoice customerInvoice = CustomerInvoiceFactory.buildCustomerInvoice(250);
        assertFalse(false);
        System.out.println(customerInvoice);
    }

}