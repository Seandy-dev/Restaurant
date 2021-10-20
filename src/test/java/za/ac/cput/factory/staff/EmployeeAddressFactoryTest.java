package za.ac.cput.factory.staff;
/* EmployeeAddressFactoryTest.java
 Entity for EmployeeAddress Factory Test
 Author: Nikitha Mbokotwana (218337906)
*/
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.staffDetail.EmployeeAddress;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeAddressFactoryTest {
    @Test
    public void createEmployeeAddress(){
        EmployeeAddress employeeAddress = EmployeeAddressFactory.createEmployeeAddress("2425 Masemola road", "24MR");
        assertNotNull(employeeAddress);
        System.out.println(employeeAddress);
    }

}