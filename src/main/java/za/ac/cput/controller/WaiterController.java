package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.staff.Waiter;
import za.ac.cput.factory.staff.WaiterFactory;
import za.ac.cput.service.staff.WaiterService;

import java.util.Set;

@RestController
@RequestMapping("/waiter")
public class WaiterController {
    @Autowired
    private WaiterService waiterService;

    @PostMapping("/create")
    public Waiter create(@RequestBody Waiter waiter){
        Waiter newWaiter = WaiterFactory.buildWaiter(waiter.getHourlyWage(), waiter.getHours(), waiter.getTip());
        return waiterService.create(newWaiter);
    }

    @GetMapping("/read/{id}")
    public Waiter read(@PathVariable String id){
        return waiterService.read(id);
    }

    @PostMapping("/update")
    public Waiter update(@RequestBody Waiter waiter){
        return waiterService.update(waiter);
    }

    @DeleteMapping ("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return waiterService.delete(id);
    }

//    @GetMapping("/getall")
//    public Set<Waiter> getAll(){
//        return waiterService.getall();
//    }
//
//    @GetMapping("/getAllHourlyWage")
//    public Set<Waiter> getAllHourlyWage(){
//       return waiterService.getAllHourlyWage() ;
//    }
}
