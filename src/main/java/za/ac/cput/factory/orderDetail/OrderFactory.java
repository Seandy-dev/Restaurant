package za.ac.cput.factory.orderDetail;

import za.ac.cput.entity.orderDetail.Order;

/**
 * Name : Devon Sherwyn May
 * Student number : 219168296
 */
public class OrderFactory
{
    public  static Order createOrder(int orderNumber, long orderDate)
    {
        Order order = new Order.Builder()
                .setOrderNumber(orderNumber)
                .setOrderDate(orderDate)
                .build();
        return order;
    }


}
