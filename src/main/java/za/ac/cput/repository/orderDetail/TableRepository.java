package za.ac.cput.repository.orderDetail;
/* TableRepository.java
 Entity for Table Repository
 Author: Sindiswa Nomusa Mbhele (219279616)
*/
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.orderDetail.Ta_ble;

@Repository
public interface TableRepository extends JpaRepository<Ta_ble, String> {

}
