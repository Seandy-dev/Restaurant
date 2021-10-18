package za.ac.cput.service.staff;

import za.ac.cput.entity.staff.Waiter;
import za.ac.cput.service.IService;

import java.util.Set;

public interface IWaiterService extends IService<Waiter, String> {
    public Set<Waiter> getAll();
//    public Waiter getHourlyWage(double hourlyWage);
}
