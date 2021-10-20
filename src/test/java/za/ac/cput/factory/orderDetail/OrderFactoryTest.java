package za.ac.cput.factory.orderDetail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.entity.orderDetail.Order;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Name : Devon Sherwyn May
 * Student number : 219168296
 */
class OrderFactoryTest
{
    Order Order1;
    Order Order2;
    Order Order3;

    @BeforeEach
    void setUp()
    {
        Order1 = OrderFactory.createOrder(11,20210610 );
        Order2 = OrderFactory.createOrder(9,20210611 );
        Order3 = Order1;
    }

    @Test
    void testIdentity()              //Tests Identity
    {
        assertSame(Order1,Order3);
    }

    @Test
    void testEqual()         // Test Equality
    {
        assertEquals(Order1, Order3);
    }

    @Test
    void testNotEqual()         // Test not Equal
    {
        assertNotEquals(Order1, Order2);
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
        assertEquals(Order1, Order3);
    }
}