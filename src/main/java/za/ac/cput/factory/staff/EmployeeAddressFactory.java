package za.ac.cput.factory.staff;
/* EmployeeAddressFactory.java
 Entity for EmployeeAddressFactory
 Author: Nikitha Mbokotwana (218337906)
*/
import za.ac.cput.entity.staffDetail.EmployeeAddress;
import za.ac.cput.helper.GenericHelper;

public class EmployeeAddressFactory {

    public static EmployeeAddress createEmployeeAddress(String employeeAddressLine, String addressId){
        String aId = GenericHelper.generateId();
        EmployeeAddress employeeAddress = new EmployeeAddress.Builder()
                .setAddressId(aId)
                .setEmployeeAddress(employeeAddressLine)
                .build();
        return employeeAddress;
    }
}
