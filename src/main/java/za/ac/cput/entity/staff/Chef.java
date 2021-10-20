package za.ac.cput.entity.staff;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/*
Chef.java class
entity class
emihle menzo
218337035
 */

        import javax.persistence.Entity;
        import javax.persistence.Id;
        import javax.persistence.Table;
        import java.io.Serializable;



@Entity
@Table(name="Chef")
public class Chef implements Serializable {
    @Id
    private String employeeId;
    private double salary;
    private int yearsOfExperience;


    private Chef(Builder builder){
        this.employeeId = builder.employeeId;
        this.salary = builder.salary;
        this.yearsOfExperience = builder.yearsOfExperience;

    }


    public String getEmployeeId() {
        return employeeId;
    }

    public double getSalary() {
        return salary;
    }

    public int getYearOfExperience(){return yearsOfExperience;}



    public static class Builder{
        private String employeeId;
        private double salary;
        private int yearsOfExperience;

        public Builder employeeId(String employeeId){
            this.employeeId = employeeId;
            return this;
        }

        public Builder salary(double salary){
            this.salary = salary;
            return this;
        }

        public Builder yearsOfExperience(int yearsOfExperience){
            this.yearsOfExperience = yearsOfExperience;
            return this;
        }


        public Builder copy(Chef chef){
            this.employeeId = chef.employeeId;
            this.salary = chef.salary;
            this.yearsOfExperience = chef.yearsOfExperience;
            return this;
        }

        public Chef build(){
            return new Chef(this);
        }
    }


}
