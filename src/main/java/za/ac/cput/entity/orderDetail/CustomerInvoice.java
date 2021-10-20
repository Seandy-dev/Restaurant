package za.ac.cput.entity.orderDetail;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name="CustomerInvoice")
public class CustomerInvoice implements Serializable {
    @Id
    private static String invoiceDate;
    private double orderAmount;


    private CustomerInvoice(){}

    private CustomerInvoice(Builder builder){
        this.invoiceDate = builder.invoiceDate;
        this.orderAmount = builder.orderAmount;

    }

    public static String getInvoiceDate() {
        return invoiceDate;
    }

    public double getOrderAmount() {
        return orderAmount;
    }



    public static class Builder{
        private String invoiceDate;
        private double orderAmount;


        public Builder invoiceDate(String invoiceDate){
            this.invoiceDate = invoiceDate;
            return this;
        }

        public Builder orderAmount(double orderAmount){
            this.orderAmount = orderAmount;
            return this;
        }


        public Builder copy(CustomerInvoice customerInvoice){
            this.invoiceDate = customerInvoice.invoiceDate;
            this.orderAmount = customerInvoice.orderAmount;

            return this;
        }

        public CustomerInvoice build(){
            return new CustomerInvoice(this);
        }
    }

    @Override
    public String toString() {
        return "CustomerInvoice{" +
                "invoiceDate=" + invoiceDate +
                ", orderAmount=" + orderAmount +
                '}';
    }
}
