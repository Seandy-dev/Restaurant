package za.ac.cput.entity.staffDetail;

import za.ac.cput.entity.staff.Employee;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/* EmployeeAddress.java
 Entity for EmployeeAddress
 Author: Nikitha Mbokotwana (218337906)
*/
@Entity
@Table(name="employeeAddress")
public class EmployeeAddress implements Serializable{
    @Id
    private String employeeAddressLine;
    private String addressId;

    private EmployeeAddress(Builder builder) {
        this.employeeAddressLine= builder.employeeAddressLine;
        this.addressId= builder.addressId;
    }

    public String getEmployeeAddressLine() {
        return employeeAddressLine;
    }

    public String getAddressId() {
        return addressId;
    }

    //Inner class
    public static class Builder{
        private String employeeAddressLine, addressId;

        public Builder setEmployeeAddress(String employeeAddress) {
            this.employeeAddressLine = employeeAddress;
            return this;
        }

        public Builder setAddressId(String addressId) {
            this.addressId = addressId;
            return this;
        }
        public EmployeeAddress build(){
            return new EmployeeAddress(this);
        }
        public Builder copy(EmployeeAddress employeeAddress){
            this.employeeAddressLine=employeeAddress.employeeAddressLine;
            this.addressId=employeeAddress.addressId;
            return this;
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "employeeAddress1='" + employeeAddressLine + '\'' +
                    ", addressId='" + addressId + '\'' +
                    '}';
        }
    }

}
