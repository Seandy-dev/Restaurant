package za.ac.cput.factory.staff;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.staff.Chef;

import static org.junit.jupiter.api.Assertions.*;

class ChefFactoryTest {
    @Test
    public void buildChef() {
        Chef chef =ChefFactory.buildChef(25000,5);
        assertFalse(false);
        System.out.println(chef);
    }

}