package com.example.cache.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.cache.model.Order;
import com.example.cache.service.OrderService;

@RestController
@RequestMapping("/api")
public class OrderController
{
    @Autowired
    private OrderService orderService;
    @PostMapping("/save")
    public Order save(@RequestBody Order order)
    {
        return orderService.save(order);
    }
    @GetMapping("/findAll")
    public List<Order> findAll()
    {
        return orderService.findAll();
    }
    @GetMapping("/findById/{id}")
    public Order findById(@PathVariable String id)
    {
        return orderService.findOrderById(id);
    }
    @DeleteMapping("/remove/{id}")
    public String remove(@PathVariable String id)
    {
        return orderService.deleteOrder(id);
    }
    @PostMapping("/update/{id}")
    public Order update(@PathVariable String id, @RequestBody Order order)
    {
        return orderService.updateOrder(id, order);
    }
}
