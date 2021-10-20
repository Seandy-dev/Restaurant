package za.ac.cput.entity.orderDetail;

import javax.persistence.Id;
import java.io.Serializable;
/**
 * Name : Devon Sherwyn May
 * Student number : 219168296
 */

public class OrderItem implements Serializable
{
    @Id
    private int Quantity;

    public OrderItem() {

    }

    public int getQuantity()
    {
        return Quantity;
    }
    private OrderItem(Builder builder)
    {
        this.Quantity= builder.Quantity;
    }

    @Override
    public String toString()
    {
        return "OrderItem{" +
                "Quantity=" + Quantity +
                '}';
    }

    public static class Builder
    {
        private int Quantity;

        public Builder setQuantity(int quantity)
        {
            this.Quantity = quantity;
            return this;
        }

        public OrderItem build()
        {
            return new OrderItem(this);
        }

        public Builder copy(OrderItem orderitem)
        {
            this.Quantity = orderitem.Quantity;
            return this;
        }

    }
}

