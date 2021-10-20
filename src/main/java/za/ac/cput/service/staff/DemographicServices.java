package za.ac.cput.service.staff;

import za.ac.cput.entity.staffDetail.Demographic;
import za.ac.cput.service.IService;

import java.util.Set;

public interface DemographicServices extends IService<Demographic, String> {
    public Set<Demographic> getAll();
}
