package za.ac.cput.entity.staff;

public class Chef {
    private String employeeId;
    private int yearsOfExperience;
    private double salary;

    private Chef(Builder builder){
        this.employeeId = builder.employeeId;
        this.yearsOfExperience = builder.yearsOfExperience;
        this.salary = builder.salary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public double getSalary() {
        return salary;
    }

    public static class Builder{
        private String employeeId;
        private int yearsOfExperience;
        private double salary;

        public Builder employeeId(String employeeId){
            this.employeeId = employeeId;
            return this;
        }

        public Builder yearsOfExperience(int yearsOfExperience){
            this.yearsOfExperience = yearsOfExperience;
            return this;
        }

        public Builder salary(double salary){
            this.salary = salary;
            return this;
        }

        public Builder copy(Chef chef){
            this.employeeId = chef.employeeId;
            this.yearsOfExperience = chef.yearsOfExperience;
            this.salary = chef.salary;
            return this;
        }

        public Chef build(){
            return new Chef(this);
        }
    }

    @Override
    public String toString() {
        return "Chef{" +
                "employeeId=" + employeeId +
                ", yearsOfExperience=" + yearsOfExperience +
                ", salary=" + salary +
                '}';
    }
}
