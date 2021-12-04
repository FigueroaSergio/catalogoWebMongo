/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.catalogo.catalogo.Repositories;

import com.catalogo.catalogo.Entities.Order;
import com.catalogo.catalogo.Interfaces.OrderInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author figue
 */
@Repository
public class OrderRepository {
    @Autowired
    private OrderInterface crud3;
    public List<Order> getAll(){
	        return (List<Order>) crud3.findAll();
	    }
    public Order save(Order order){
	        return crud3.save(order);
	    }
    public Order getOrderById(int id){
	        return crud3.findById(id).orElse(null);
	    }
   
    public List<Order> getByZone(String zone){
	        return (List<Order>) crud3.getByOrderZone(zone);
	    }
    public Order updateOrder(Order order){
                Order orderDB=crud3.findById(order.getId()).orElse(null);
                if(orderDB==null){
                    return order;
                }
                else{
                    orderDB.setStatus(order.getStatus());
                    return crud3.save(orderDB);
                }
	       
	    }
    
}
