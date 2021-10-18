package za.ac.cput.entity.staff;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/* Waiter.java
 Entity for Waiter
 Author: Sindiswa Nomusa Mbhele (219279616)
*/
@Entity
@Table(name="waiter")
public class Waiter implements Serializable {
    @Id
    private String employeeId;
    private double hourlyWage;
    private int hours;
    private double tip;

    private Waiter(){}

    private Waiter(Builder builder){
        this.employeeId = builder.employeeId;
        this.hourlyWage = builder.hourlyWage;
        this.hours = builder.hours;
        this.tip = builder.tip;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public int getHours() {
        return hours;
    }

    public double getTip() {
        return tip;
    }

    public static class Builder{
        private String employeeId;
        private double hourlyWage;
        private int hours;
        private double tip;

        public Builder employeeId(String employeeId){
            this.employeeId = employeeId;
            return this;
        }

        public Builder hourlyWage(double hourlyWage){
            this.hourlyWage = hourlyWage;
            return this;
        }

        public Builder hours(int hours){
            this.hours = hours;
            return this;
        }

        public Builder tip(double tip){
            this.tip = tip;
            return this;
        }

        public Builder copy(Waiter waiter){
            this.employeeId = waiter.employeeId;
            this.hourlyWage = waiter.hourlyWage;
            this.hours = waiter.hours;
            this.tip = waiter.tip;
            return this;
        }

        public Waiter build(){
            return new Waiter(this);
        }
    }

    @Override
    public String toString() {
        return "Waiter{" +
                "employeeId=" + employeeId +
                ", hourlyWage=" + hourlyWage +
                ", hours=" + hours +
                ", tip=" + tip +
                '}';
    }
}
