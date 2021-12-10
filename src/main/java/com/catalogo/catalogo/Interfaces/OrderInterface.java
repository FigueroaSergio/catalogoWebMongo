/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.catalogo.catalogo.Interfaces;

import com.catalogo.catalogo.Entities.Order;
import static java.util.Collections.list;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author figue
 */
public interface OrderInterface extends MongoRepository<Order,Integer>{
    
    @Query("{'salesMan.zone': ?0 }")
    List<Order> getByOrderZone(String zone);
    
    @Query("{'salesMan._id': ?0 }")
    List<Order> getOrderBySalesman(int id);
    
    @Query("{$and:[ {registerDay:{$gte: {$date:?0}} }, {registerDay:{$lte: {$date:?1}} },{'salesMan._id': ?2 }]}")
    List<Order> getOrderByDateAndSalesman(Date a,Date b , int id);
    
    @Query("{status:?0,'salesMan._id': ?1}")
    List<Order> getOrderByStateAndSalesman(String state , int id);

}
