package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.staff.Chef;
import za.ac.cput.factory.staff.ChefFactory;
import za.ac.cput.service.staff.ChefService;

@RestController
@RequestMapping("/Chef")
public class ChefController {

    @Autowired
    private ChefService chefService;

    @PostMapping("/create")
    public Chef create(@RequestBody Chef chef){
        Chef newChef = ChefFactory.buildChef(chef.getSalary(), chef.getYearOfExperience());
        return chefService.create(newChef);
    }

    @GetMapping("/read/{id}")
    public Chef read(@PathVariable String id){
        return chefService.read(id);
    }

    @PostMapping("/update")
    public Chef update(@RequestBody Chef chef){
        return chefService.update(chef);
    }

    @DeleteMapping ("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return chefService.delete(id);
    }


}
