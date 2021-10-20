package za.ac.cput.service.staff;
/* IEmployeeService.java
 * Thina Mbiza- 217217095
 */
import za.ac.cput.entity.staff.Employee;
import za.ac.cput.service.IService;

import java.util.Set;

public interface IEmployeeService extends IService<Employee, String> {
    public Set<Employee> getAll();
}
