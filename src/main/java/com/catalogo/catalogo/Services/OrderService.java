/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.catalogo.catalogo.Services;

import com.catalogo.catalogo.Entities.Order;
import com.catalogo.catalogo.Repositories.OrderRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
                order.setId(sequenceGenerator.generateSequence(Order.SEQUENCE_NAME));
            }
            return repoOrder.save(order);    
    }

    public Order updateOrder(Order order) {
        return repoOrder.updateOrder(order);
    }

    public List<Order> getOrderBySalesman(int id) {
        return repoOrder.getOrderBySalesman(id);
    }

    public List<Order> getOrderByDateAndSalesman(String date, int id) {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'hh:ss:mm.SSS+00:00");
        
        Date a = new Date();
         Date b;
  
        try{
            a = parser.parse(date);
        }
        catch(ParseException evt){
            evt.printStackTrace();
        }
        
        String data = format.format(a);
             System.out.println(data); 
             System.out.println(a); 
             b= new Date(a.getTime() + (1000 * 60 * 60 * 24));
       List<Order> orders= repoOrder.getOrderByDateAndSalesman(a,b, id);
       
        return orders;
       
        
    }

    public List<Order> getOrderByStateAndSalesman(String status, int id) {
        return repoOrder.getOrderByStateAndSalesman(status, id);
    }
    
}
