package za.ac.cput.repository.staff;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.staffDetail.EmployeeAddress;
@Repository
public interface EmployeeAddressRepository extends JpaRepository<EmployeeAddress, String> {
}
