package za.ac.cput.service.staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.staff.Waiter;
import za.ac.cput.repository.staff.WaiterRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class WaiterService implements IWaiterService{
    public static WaiterService service = null;

    @Autowired
    private WaiterRepository repository;

    @Override
    public Waiter create(Waiter waiter) {
        return this.repository.save(waiter);
    }

    @Override
    public Waiter update(Waiter waiter) {
        if(this.repository.existsById(waiter.getEmployeeId()))
            return this.repository.save(waiter);
        return null;
    }

    @Override
    public Waiter read(String waiterId) {
        return this.repository.findById(waiterId).orElse(null);
    }

    @Override
    public boolean delete(String waiterId) {
        this.repository.deleteById(waiterId);
        if(this.repository.existsById(waiterId))
            return false;
        else
            return true;
    }

    @Override
    public Set<Waiter> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

//    @Override
//    public Waiter getHourlyWage(double hourlyWage) {
//        return null;
//    }
}
