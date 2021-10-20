package za.ac.cput.repository.staff;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.staff.Chef;
@Repository
public interface ChefRepository extends JpaRepository<Chef, String> {
}