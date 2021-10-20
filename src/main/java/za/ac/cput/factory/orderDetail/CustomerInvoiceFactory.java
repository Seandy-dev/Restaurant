package za.ac.cput.factory.orderDetail;

import za.ac.cput.helper.GenericHelper;
import za.ac.cput.entity.orderDetail.CustomerInvoice;
import za.ac.cput.helper.GenericHelper;

public class CustomerInvoiceFactory {

    public static za.ac.cput.entity.orderDetail.CustomerInvoice buildCustomerInvoice(double orderAmount) {
        if (GenericHelper.isNullorEmpty(orderAmount) || GenericHelper.isNullorEmpty(orderAmount))
            return new za.ac.cput.entity.orderDetail.CustomerInvoice.Builder().build();
        String invoiceDate = GenericHelper.generateId();
        return new za.ac.cput.entity.orderDetail.CustomerInvoice.Builder().invoiceDate(invoiceDate).orderAmount(orderAmount).build();
    }

}


