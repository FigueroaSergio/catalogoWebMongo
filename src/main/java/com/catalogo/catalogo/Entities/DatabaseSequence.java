/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.catalogo.catalogo.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author figue
 */
@Document(collection = "database_sequences")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DatabaseSequence {
    @Id 
    private String id;
    private int count=0;

  
    public int getCount(){
        return this.count;
    }
    public int setCount(int count){
        return this.count=count;
    }
    public String getId(){
        return this.id;
    }
    public String setId(String id){
        return this.id=id;
    }
   
   
}
