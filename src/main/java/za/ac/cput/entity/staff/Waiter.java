package za.ac.cput.entity.staff;

public class Waiter {
    private double hourlyWage;
    private int hours;
    private double tip;

    private Waiter(Builder builder){
        this.hourlyWage = builder.hourlyWage;
        this.hours = builder.hours;
        this.tip = builder.tip;
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
        private double hourlyWage;
        private int hours;
        private double tip;

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
                "hourlyWage=" + hourlyWage +
                ", hours=" + hours +
                ", tip=" + tip +
                '}';
    }
}
