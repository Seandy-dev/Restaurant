package za.ac.cput.service.orderDetail;

import za.ac.cput.entity.orderDetail.Order;
import za.ac.cput.service.IService;

import java.util.Set;

/**
 * Name : Devon Sherwyn May
 * Student number : 219168296
 */
public interface IOrderRepository extends IService<Order, Integer>
{
    public Set<Order> getAll();
}
