package za.ac.cput.repository.staff;

/* EmployeeRepository.java
 * THina Mbiza- 217217095
 */


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.staff.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
