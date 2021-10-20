package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.orderDetail.Order;
import za.ac.cput.factory.orderDetail.OrderFactory;
import za.ac.cput.service.orderDetail.OrderService;

/**
 * Name : Devon Sherwyn May
 * Student number : 219168296
 */

@RestController
@RequestMapping("/order")
public class OrderController
{
    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public Order create(@RequestBody Order order)
    {
        Order newOrder = OrderFactory.createOrder(order.getOrderNumber(), order.getOrderDate());
        return orderService.create(newOrder);
    }

    @GetMapping("/read/{id}")
    public Order read(@RequestBody Order order)
    {
        return orderService.read(order.getOrderNumber());
    }

    @PostMapping("/update")
    public Order update(@RequestBody Order order)
    {
        return orderService.update(order);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@RequestBody Order order)
    {
        if(orderService.delete(order.getOrderNumber()))
            return "successfully deleted";
        else
            return "couldn't delete";
    }
}
