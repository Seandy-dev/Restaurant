package za.ac.cput.service.staff;

/*
ChefService.java class
Author: Emihle Menzo
218337035
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.staff.Chef;

import za.ac.cput.repository.staff.ChefRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ChefService implements IChefService{
    public static ChefService service = null;

    @Autowired
    private ChefRepository repository;

    @Override
    public Chef create(Chef chef) {
        return this.repository.save(chef);
    }

    @Override
    public Chef update(Chef chef) {
        if(this.repository.existsById(chef.getEmployeeId()))
            return this.repository.save(chef);
        return null;
    }

    @Override
    public Chef read(String ChefId) {
        return this.repository.findById(ChefId).orElse(null);
    }

    @Override
    public boolean delete(String ChefId) {
        this.repository.deleteById(ChefId);
        if(this.repository.existsById(ChefId))
            return false;
        else
            return true;
    }

    @Override
    public Set<Chef> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }


}

