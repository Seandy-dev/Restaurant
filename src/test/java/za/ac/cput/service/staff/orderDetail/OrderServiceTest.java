package za.ac.cput.service.staff.orderDetail;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.orderDetail.Order;
import za.ac.cput.factory.orderDetail.OrderFactory;
import za.ac.cput.service.orderDetail.OrderService;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Name : Devon Sherwyn May
 * Student number : 219168296
 */
class OrderServiceTest
{

    private static OrderService service = new OrderService();
    private static Order order = OrderFactory.createOrder(10, 20201018);

    @Test
    void create() {
        Order created = service.create(order);
        assertEquals(order.getOrderNumber(),created.getOrderNumber());
        assertEquals(order.getOrderDate(),created.getOrderDate());
        System.out.println("Created" + created);
    }

    @Test
    void read() {
        Order read = service.read(order.getOrderNumber());
        System.out.println("Read " + read);
    }

    @Test
    void update() {
        Order updated = new Order.Builder().copy(order).setOrderNumber(20).setOrderDate(20200909).build();
        System.out.println("updated" + updated);
    }

    @Test
    void delete() {
        service.delete(order.getOrderNumber());
        System.out.println("Deleted" + order.getOrderNumber() + "");
    }
}
