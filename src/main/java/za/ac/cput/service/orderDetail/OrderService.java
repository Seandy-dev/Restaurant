package za.ac.cput.service.orderDetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.orderDetail.Order;
import za.ac.cput.repository.orderDetail.OrderRepository;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Name : Devon Sherwyn May
 * Student number : 219168296
 */
@Service
public class OrderService implements IOrderRepository
{
    private static OrderService service = null;

    @Autowired
    private OrderRepository repository;

    @Override
    public Order create(Order order) {
        return this.repository.save(order);
    }

    @Override
    public Order update(Order order) {
        if(this.repository.existsById(order.getOrderNumber()))
            return this.repository.save(order);
        return order;
    }

    @Override
    public Order read(Integer integer) {
        return null;
    }


    @Override
    public boolean delete(Integer integer) {
        this.repository.deleteById(integer);
        if(this.repository.existsById(integer))
            return false;
        else
            return true;
    }

    @Override
    public Set<Order> getAll() {return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}
