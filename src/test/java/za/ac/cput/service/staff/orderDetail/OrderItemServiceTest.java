package za.ac.cput.service.staff.orderDetail;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.orderDetail.OrderItem;
import za.ac.cput.factory.orderDetail.OrderItemFactory;
import za.ac.cput.service.orderDetail.OrderItemService;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Name : Devon Sherwyn May
 * Student number : 219168296
 */
class OrderItemServiceTest {
    private static OrderItemService service = new OrderItemService();
    private static OrderItem orderitem = OrderItemFactory.createOrderItem(10);

    @Test
    void create() {
        OrderItem created = service.create(orderitem);
        assertEquals(orderitem.getQuantity(), created.getQuantity());
        System.out.println("Created" + created);
    }

    @Test
    void read() {
        OrderItem read = service.read(orderitem.getQuantity());
        System.out.println("Read " + read);
    }

    @Test
    void update() {
        OrderItem updated = new OrderItem.Builder().copy(orderitem).setQuantity(20).build();
        System.out.println("updated" + updated);
    }

    @Test
    void delete() {
        service.delete(orderitem.getQuantity());
        System.out.println("Deleted" + orderitem.getQuantity() + "");
    }
}