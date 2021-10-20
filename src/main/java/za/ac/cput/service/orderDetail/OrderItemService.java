package za.ac.cput.service.orderDetail;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.entity.orderDetail.OrderItem;
import za.ac.cput.repository.orderDetail.OrderItemRepository;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Name : Devon Sherwyn May
 * Student number : 219168296
 */
public class OrderItemService implements IOrderItemRepository
{

    public static OrderItemService service = null;

    @Autowired
    private OrderItemRepository repository;

    @Override
    public OrderItem create(OrderItem orderItem) {
    return this.repository.save(orderItem);
}

    @Override
    public OrderItem update(OrderItem orderItem) {
    if(this.repository.existsById(orderItem.getQuantity()))
        return this.repository.save(orderItem);
        return orderItem;
    }

    @Override
    public OrderItem read(Integer integer) {
        return null;
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }


    @Override
    public Set<OrderItem> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}
