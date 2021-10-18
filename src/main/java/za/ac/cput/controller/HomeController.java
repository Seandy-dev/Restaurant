package za.ac.cput.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping
//@EnableAutoConfiguration
public class HomeController {
    @RequestMapping({"/", "/home"})
    public String name(){
        return "Restaurant Application";
    }

}
