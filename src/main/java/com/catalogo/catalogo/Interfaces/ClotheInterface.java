/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.catalogo.catalogo.Interfaces;

import com.catalogo.catalogo.Entities.Clothe;
import com.catalogo.catalogo.Entities.User;
import java.util.Optional;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author figue
 */
public interface ClotheInterface extends MongoRepository<Clothe,String>{
   @Query("{description:{ $regex: ?0,$options: 'i'}}")
   List<Clothe> getClotheByDescription(String des);
    @Query("{price:?0}")
   List<Clothe> getClotheByPrice(Integer des);
}
