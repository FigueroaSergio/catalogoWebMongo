/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.catalogo.catalogo.Services;

import com.catalogo.catalogo.Entities.Clothe;
import com.catalogo.catalogo.Entities.Order;
import com.catalogo.catalogo.Repositories.OrderRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author figue
 */
@Service
public class OrderService {
    @Autowired
    private OrderRepository repoOrder;
    @Autowired
    private generateSequence sequenceGenerator;

    public List<Order> getAll() {
        return repoOrder.getAll();
    }

    public List<Order> getOrdersByZone(String zone) {
        return repoOrder.getByZone(zone);
    }

    public Order getOrderById(int id) {
        return repoOrder.getOrderById(id);
    }

    public Order save(Order order) {
             if(order.getId()==null){
                order.setId(sequenceGenerator.generateSequence(Clothe.SEQUENCE_NAME));
            }
            return repoOrder.save(order);    
    }
    
}
