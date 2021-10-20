package za.ac.cput.factory.staff;

/* EmployeeFactoryTest.java
 * Thina Mbiza- 217217095
 */
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.staff.Employee;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeFactoryTest {
    @Test
    public void buildEmployee(){
        Employee employee = EmployeeFactory.buildEmployee("452131", "Chef", "Thina", "Mbiza");
        assertNotNull(employee);
        System.out.println(employee);
    }
}