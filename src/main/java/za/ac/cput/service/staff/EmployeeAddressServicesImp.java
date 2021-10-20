package za.ac.cput.service.staff;
/* EmployeeAddressServicesImp.java
 Entity for EmployeeAddressServicesImp
 Author: Nikitha Mbokotwana (218337906)
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.staffDetail.EmployeeAddress;
import za.ac.cput.repository.staff.EmployeeAddressRepository;

import java.util.Set;
import java.util.stream.Collectors;
@Service
public class EmployeeAddressServicesImp implements EmployeeAddressServices{
        private static EmployeeAddressServices services = null;

        @Autowired
        private EmployeeAddressRepository repository;

        @Override
        public EmployeeAddress create(EmployeeAddress employeeAddress) {
            return this.repository.save(employeeAddress);
        }

        @Override
        public EmployeeAddress update(EmployeeAddress employeeAddress) {
            if (this.repository.existsById(employeeAddress.getAddressId()))
                return this.repository.save(employeeAddress);
            return null;
        }

        @Override
        public EmployeeAddress read(String addressId) {
            return this.repository.findById(addressId).orElse(null);
        }

        @Override
        public boolean delete(String addressId) {
            this.repository.deleteById(addressId);
            if (this.repository.existsById(addressId))
                return false;
            else
                return true;
        }

        @Override
        public Set<EmployeeAddress> getAll() {
            return this.repository.findAll().stream().collect(Collectors.toSet());
        }
    }
