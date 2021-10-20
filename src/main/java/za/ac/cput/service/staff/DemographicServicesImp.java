package za.ac.cput.service.staff;
/* DemographicServicesImp.java
 Entity for DemographicServicesImp
 Author: Nikitha Mbokotwana (218337906)
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.staffDetail.Demographic;
import za.ac.cput.repository.staff.DemographicRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DemographicServicesImp implements DemographicServices {
    private static DemographicServices services = null;

    @Autowired
    private DemographicRepository repository;

    @Override
    public Demographic create(Demographic demographic) {
        return this.repository.save(demographic);
    }

    @Override
    public Demographic update(Demographic demographic) {
        if(this.repository.existsById(demographic.getBirthDate()))
            return this.repository.save(demographic);
        return null;
    }

    @Override
    public Demographic read(String birthDate) {
        return this.repository.findById(birthDate).orElse(null);
    }

    @Override
    public boolean delete(String birthDate) {
        this.repository.deleteById(birthDate);
        if(this.repository.existsById(birthDate))
            return false;
        else
            return true;
    }

    @Override
    public Set<Demographic> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}
