package za.ac.cput.factory.staff;
/* EmployeeFactory.java
 * Thina Mbiza- 217217095
 */

import za.ac.cput.entity.staff.Employee;
import za.ac.cput.helper.GenericHelper;

public class EmployeeFactory {
    public static Employee buildEmployee(String employeeNumber, String positionId, String firstName, String lastName){
        if (GenericHelper.isNullorEmpty(employeeNumber) || GenericHelper.isNullorEmpty(positionId))
            return  new Employee.Builder().build();
        String employeeId = GenericHelper.generateId();
        return  new Employee.Builder()
                .employeeNumber(employeeNumber)
                .positionId(positionId)
                .firstName(firstName)
                .lastName(lastName)
                .build();
    }

  /*  public static void main(String[] args) {

    }*/


}
