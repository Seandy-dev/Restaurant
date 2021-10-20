package za.ac.cput.controller;
/*
CustomerInvoiceController class
emihle menzo
218337035

 */

import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.orderDetail.CustomerInvoice;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.factory.orderDetail.CustomerInvoiceFactory;
import za.ac.cput.service.orderDetail.CustomerInvoiceService;

@RestController
@RequestMapping("/customerInvoice")
class customerInvoiceController {
    @Autowired
    private CustomerInvoiceService customerInvoiceService;

    @PostMapping("/create")
    public CustomerInvoice create(@RequestBody CustomerInvoice customerInvoice){
        CustomerInvoice newCustomerInvoice = CustomerInvoiceFactory.buildCustomerInvoice(Double.parseDouble(customerInvoice.getInvoiceDate()));
        return customerInvoiceService.create(newCustomerInvoice);
    }

    @GetMapping("/read/{id}")
    public CustomerInvoice read(@PathVariable String id){
        return customerInvoiceService.read(id);
    }

    @PostMapping("/update")
    public CustomerInvoice update(@RequestBody CustomerInvoice customerInvoice){
        return customerInvoiceService.update(customerInvoice);
    }

    @DeleteMapping ("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return customerInvoiceService.delete(id);
    }

}
