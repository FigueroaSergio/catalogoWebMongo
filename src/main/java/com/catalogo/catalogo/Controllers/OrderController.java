package com.catalogo.catalogo.Controllers;

import com.catalogo.catalogo.Entities.Order;
import com.catalogo.catalogo.Services.OrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author figue
 */
@RestController
@RequestMapping("/api/order")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class OrderController {
    @Autowired
    private OrderService servicio;
    @GetMapping("/all")
    public List<Order> getOrders(){
        return servicio.getAll();
    }
    @GetMapping("/zona/{zone}")
    public List<Order> getOrdersByZone(@PathVariable("zone") String zone){
        return servicio.getOrdersByZone(zone);
    }
    @GetMapping("/{id}")
    public Order getOrdersByZone(@PathVariable("id") int id){
        return servicio.getOrderById(id);
    }
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order save(@RequestBody Order order) {
        return servicio.save(order);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order updateOrder(@RequestBody Order order) {
        return servicio.updateOrder(order);
    }
}
