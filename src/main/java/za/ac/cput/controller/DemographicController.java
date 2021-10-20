package za.ac.cput.controller;
/* DemographicController.java
 Entity for DemographicController
 Author: Nikitha Mbokotwana (218337906)
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.staffDetail.Demographic;
import za.ac.cput.factory.staff.DemographicFactory;
import za.ac.cput.service.staff.DemographicServices;

@RestController
@RequestMapping("/demographic")
public class DemographicController {

    @Autowired
    private DemographicServices demographicService;

    @PostMapping("/create")
    public Demographic create(@RequestBody Demographic demographic) {
        Demographic newDemographic = DemographicFactory.createDemographic(demographic.getGender(), demographic.getBirthDate());
        return demographicService.create(newDemographic);
    }

    @GetMapping("/read/{id}")
    public Demographic read(@PathVariable String id) {
        return demographicService.read(id);
    }

    @PostMapping("/update")
    public Demographic update(@RequestBody Demographic demographic) {
        return demographicService.update(demographic);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id) {
        return demographicService.delete(id);
    }
}