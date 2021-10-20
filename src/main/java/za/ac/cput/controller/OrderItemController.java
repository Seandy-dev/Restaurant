package za.ac.cput.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.orderDetail.OrderItem;
import za.ac.cput.factory.orderDetail.OrderItemFactory;
import za.ac.cput.service.orderDetail.OrderItemService;

/**
 * Name : Devon Sherwyn May
 * Student number : 219168296
 */

@RestController
@RequestMapping("/orderItem")
public class OrderItemController
{
    @Autowired
    private OrderItemService orderItemService;

    @PostMapping("/create")
    public OrderItem create(@RequestBody OrderItem orderItem){
        OrderItem newOrderItem = OrderItemFactory.createOrderItem(orderItem.getQuantity());
        return orderItemService.create(newOrderItem);
    }

    @GetMapping("/read/{id}")
    public OrderItem read(@RequestBody OrderItem orderItem)
    {
        return orderItemService.read(orderItem.getQuantity());
    }

    @PostMapping("/update")
    public OrderItem update(@RequestBody OrderItem orderItem){
        return orderItemService.update(orderItem);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@RequestBody OrderItem orderItem)
    {
        if(orderItemService.delete(orderItem.getQuantity())) {
            return "successfully deleted";
        } else
            return "couldn't delete";

    }
}

