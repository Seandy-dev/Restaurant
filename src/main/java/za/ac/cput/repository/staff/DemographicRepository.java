package za.ac.cput.repository.staff;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.staffDetail.Demographic;

@Repository
public interface DemographicRepository extends JpaRepository<Demographic, String> {
}
