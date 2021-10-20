package za.ac.cput.factory.orderDetail;

import za.ac.cput.entity.orderDetail.OrderItem;

/**
 * Name : Devon Sherwyn May
 * Student number : 219168296
 */
public class OrderItemFactory
{
    public  static OrderItem createOrderItem(int quantity)
    {

        OrderItem orderItem = new OrderItem.Builder()
                .setQuantity(quantity)
                .build();
        return orderItem;
    }
}
