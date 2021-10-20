package za.ac.cput.factory.orderDetail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.entity.orderDetail.OrderItem;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Name : Devon Sherwyn May
 * Student number : 219168296
 */
class OrderItemFactoryTest
{
    OrderItem OrderOne;
    OrderItem OrderTwo;
    OrderItem OrderThree;

    @BeforeEach
    void setUp() {
        OrderOne = OrderItemFactory.createOrderItem(12);
        OrderTwo = OrderItemFactory.createOrderItem(15);
        OrderThree = OrderOne;
    }

    @Test
    void testIdentity()              //Tests Identity
    {
        assertSame(OrderOne, OrderThree);
    }

    @Test
    void testEqual()         // Test Equality
    {
        assertEquals(OrderOne, OrderThree);
    }

    @Test
    void testNotEqual()         // Test not Equal
    {
        assertNotEquals(OrderOne, OrderTwo);
    }


    @Timeout(3)
    @Test
    void testTimeoutLoop() throws Exception      // Tests timeout after 3 seconds
    {
        while (true)
        {
            Thread.sleep(1000);
        }
    }

    @Test
    @Disabled("Test disabled")
    void testDisabled()
    {
        assertEquals(OrderOne, OrderThree);
    }
}