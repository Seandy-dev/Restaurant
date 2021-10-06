package za.ac.cput.factory.staff;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.staff.Waiter;

import static org.junit.jupiter.api.Assertions.*;

class WaiterFactoryTest {
    @Test
    public void buildWaiter() {
        Waiter waiter = WaiterFactory.buildWaiter(500.00, 8, 90.50);
        assertNotNull(waiter);
        System.out.println(waiter);
    }

}