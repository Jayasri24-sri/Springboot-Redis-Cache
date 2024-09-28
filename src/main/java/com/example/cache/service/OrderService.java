package com.example.cache.service;
import com.example.cache.model.Order;
import com.example.cache.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService
{
    @Autowired
    private OrderRepository repository;
    @CachePut(value = "order", key = "#order.id")
    public Order save(Order order)
    {
        return repository.save(order);
    }
    public List<Order> findAll()
    {
        return repository.findAll();
    }
    public Order findOrderById(String id)
    {
        return repository.findById(id).orElse(null);
    }
    @Caching(evict = {@CacheEvict(value = "order",key = "#id"),@CacheEvict(value = "order",key = "'allOrders'")})
    public String deleteOrder(String id)
    {
        repository.deleteById(id);
        return "Order deleted successfully!";
    }
    @Caching(put = @CachePut(value = "order",key = "#id"),evict = @CacheEvict(value = "order",key = "'allOrders'"))
    public Order updateOrder(String id, Order order)
    {
        return repository.save(order);
    }
}
