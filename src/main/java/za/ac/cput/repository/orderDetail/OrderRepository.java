package za.ac.cput.repository.orderDetail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.orderDetail.Order;

/**
 * Name : Devon Sherwyn May
 * Student number : 219168296
 */
@Repository
public interface OrderRepository extends JpaRepository<Order,Integer>
{
}
