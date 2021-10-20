package za.ac.cput.service.staff;
/* EmployeeService.java
 * Thina Mbiza- 217217095
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.staff.Employee;

import za.ac.cput.repository.staff.EmployeeRepository;

/* EmployeeService.java
 * Thina Mbiza- 217217095
 */

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmployeeService implements IEmployeeService{
    public static EmployeeService service = null;

    @Autowired
    private EmployeeRepository repository;

    @Override
    public Employee create(Employee employee) {
        return this.repository.save(employee);
    }

    @Override
    public Employee update(Employee employee) {
        if(this.repository.existsById(employee.getEmployeeId()))
            return this.repository.save(employee);
        return null;
    }

    @Override
    public Employee read(String positionID) {
        return (Employee) this.repository.findById(positionID).orElse(null);
    }

    @Override
    public boolean delete(String positionID) {
        this.repository.deleteById(positionID);
        if(this.repository.existsById(positionID))
            return false;
        else
            return true;
    }


    @Override
    public Set<Employee> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

}
