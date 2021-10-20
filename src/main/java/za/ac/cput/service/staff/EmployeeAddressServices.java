package za.ac.cput.service.staff;

import za.ac.cput.entity.staffDetail.Demographic;
import za.ac.cput.entity.staffDetail.EmployeeAddress;
import za.ac.cput.service.IService;

import java.util.Set;

public interface EmployeeAddressServices extends IService<EmployeeAddress, String> {
    public Set<EmployeeAddress> getAll();
}
