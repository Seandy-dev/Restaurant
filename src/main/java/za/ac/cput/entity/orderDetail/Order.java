package za.ac.cput.entity.orderDetail;

import javax.persistence.Id;
import java.io.Serializable;
/**
 * Name : Devon Sherwyn May
 * Student number : 219168296
 */

public class Order  implements Serializable
{
    @Id
    private int orderNumber;
    private long OrderDate;

    public Order() {

    }

    public int getOrderNumber()
    {
        return orderNumber;
    }
    public long getOrderDate()
    {
        return OrderDate;
    }
    public Order(Builder builder)
    {
        this.orderNumber= builder.orderNumber;
        this.OrderDate= builder.OrderDate;
    }

    @Override
    public String toString()
    {
        return "Builder{" +
                "OrderNumber=" + orderNumber +
                ", OrderDate=" + OrderDate +
                '}';
    }

    public static class Builder
    {
        private int orderNumber;
        private long OrderDate;

        public Builder setOrderNumber(int orderNumber)
        {
            this.orderNumber = orderNumber;
            return this;
        }

        public Builder setOrderDate(long orderDate)
        {
            this.OrderDate = orderDate;
            return this;
        }

        public Order build()
        {
            return new Order(this);
        }

        public Builder copy(Order order)
        {
            this.orderNumber = order.orderNumber;
            this.OrderDate = order.OrderDate;
            return this;
        }
    }
}