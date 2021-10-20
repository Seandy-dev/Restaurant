package za.ac.cput.entity.staff;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/* Employee.java
 * Thina Mbiza- 217217095
*/
@Entity
@Table(name="employee")
public class Employee implements Serializable {
    @Id
    private String employeeId;
    private String employeeNumber;
    private String positionId;
    private String firstName;
    private String lastName;

    private Employee(){}

    private Employee(Builder builder){
        this.employeeId = builder.employeeId;
        this.employeeNumber = builder.employeeNumber;
        this.positionId = builder.positionId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public String getPositionId() {
        return positionId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public static class Builder{
        private String employeeId;
        private String employeeNumber;
        private String positionId;
        private String firstName;
        private String lastName;

        public Builder employeeId(String employeeId){
            this.employeeId = employeeId;
            return this;
        }

        public Builder employeeNumber(String employeeNumber){
            this.employeeNumber = employeeNumber;
            return this;
        }

        public Builder positionId(String positionId){
            this.positionId = positionId;
            return this;
        }

        public Builder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public Builder copy(Employee employee){
            this.employeeId = employee.employeeId;
            this.employeeNumber = employee.employeeNumber;
            this.positionId = employee.positionId;
            this.firstName = employee.firstName;
            this.lastName = employee.lastName;
            return this;
        }

        public Employee build(){
            return new Employee(this);
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", employeeNumber='" + employeeNumber + '\'' +
                ", positionId='" + positionId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
