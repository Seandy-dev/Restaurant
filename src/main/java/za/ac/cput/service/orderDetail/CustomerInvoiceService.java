package za.ac.cput.service.orderDetail;
/*
CustomerInvoiceService.java class
Author: Emihle Menzo
218337035
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.orderDetail.CustomerInvoice;
import za.ac.cput.repository.orderDetail.CustomerInvoiceRepository;
import za.ac.cput.service.orderDetail.ICustomerInvoiceService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomerInvoiceService implements ICustomerInvoiceService {
    public static CustomerInvoiceService service = null;

    @Autowired
    private CustomerInvoiceRepository repository;

    @Override
    public CustomerInvoice create(CustomerInvoice customerInvoice) {
        return this.repository.save(customerInvoice);
    }

    @Override
    public CustomerInvoice update(CustomerInvoice customerInvoice) {
        if(this.repository.existsById(customerInvoice.getInvoiceDate()))
            return this.repository.save(customerInvoice);
        return null;
    }

    @Override
    public CustomerInvoice read(String customerInvoiceId) {
        return this.repository.findById(customerInvoiceId).orElse(null);
    }

    @Override
    public boolean delete(String customerInvoiceId) {
        this.repository.deleteById(customerInvoiceId);
        if(this.repository.existsById(customerInvoiceId))
            return false;
        else
            return true;
    }

    @Override
    public Set<CustomerInvoice> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }


}
