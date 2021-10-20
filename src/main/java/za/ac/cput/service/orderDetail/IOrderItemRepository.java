package za.ac.cput.service.orderDetail;

import za.ac.cput.entity.orderDetail.OrderItem;
import za.ac.cput.service.IService;

import java.util.Set;

/**
 * Name : Devon Sherwyn May
 * Student number : 219168296
 */
public interface IOrderItemRepository extends IService<OrderItem, Integer>
{
    public Set<OrderItem> getAll();
}
