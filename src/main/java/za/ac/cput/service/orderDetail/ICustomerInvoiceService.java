package za.ac.cput.service.orderDetail;

/*
CustomerInvoiceService.java class
Author: Emihle Menzo
218337035
 */

import za.ac.cput.entity.orderDetail.CustomerInvoice;
import za.ac.cput.service.IService;
import java.util.Set;

public interface ICustomerInvoiceService extends IService<CustomerInvoice, String> {
    public Set<CustomerInvoice> getAll();

}
