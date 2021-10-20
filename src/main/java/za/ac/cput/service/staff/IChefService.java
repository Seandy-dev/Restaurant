package za.ac.cput.service.staff;

/*
IChefService.java class
Author: Emihle Menzo
218337035
 */

import za.ac.cput.entity.staff.Chef;
import za.ac.cput.service.IService;

import java.util.Set;

public interface IChefService extends IService<Chef, String> {
    public Set<Chef> getAll();

}

