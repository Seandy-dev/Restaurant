package za.ac.cput.controller;
/* EmployeeAddressController.java
 Entity for EmployeeAddressController
 Author: Nikitha Mbokotwana (218337906)
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.staffDetail.EmployeeAddress;
import za.ac.cput.factory.staff.EmployeeAddressFactory;
import za.ac.cput.service.staff.EmployeeAddressServices;

@RestController
@RequestMapping("/demographic")
public class EmployeeAddressController {

    @Autowired
    private EmployeeAddressServices employeeAddressService;

    @PostMapping("/create")
    public EmployeeAddress create(@RequestBody EmployeeAddress employeeAddress) {
        EmployeeAddress newEmployeeAddress = EmployeeAddressFactory.createEmployeeAddress(employeeAddress.getEmployeeAddressLine(), employeeAddress.getAddressId());
        return employeeAddressService.create(newEmployeeAddress);
    }

    @GetMapping("/read/{id}")
    public EmployeeAddress read(@PathVariable String id) {
        return employeeAddressService.read(id);
    }

    @PostMapping("/update")
    public EmployeeAddress update(@RequestBody EmployeeAddress employeeAddress) {
        return employeeAddressService.update(employeeAddress);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id) {
        return employeeAddressService.delete(id);
    }
}