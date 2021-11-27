/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.catalogo.catalogo.Interfaces;

import com.catalogo.catalogo.Entities.Clothe;
import com.catalogo.catalogo.Entities.User;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author figue
 */
public interface ClotheInterface extends MongoRepository<Clothe,String>{
   
    
}
