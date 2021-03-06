/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.catalogo.catalogo.Services;

import com.catalogo.catalogo.Entities.Clothe;
import com.catalogo.catalogo.Repositories.ClotheRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author figue
 */
@Service
public class ClotheService {
    @Autowired
    private ClotheRepository repoClothe;
    @Autowired
    private generateSequence sequenceGenerator;
    public List<Clothe> getAll() {
        return repoClothe.getAll();
    }
    public Clothe save(Clothe clothe){
            if(clothe.getReference()==null){
                clothe.setReference(Integer.toString(sequenceGenerator.generateSequence(Clothe.SEQUENCE_NAME)));
            }
            return repoClothe.save(clothe);
    }

    public Clothe updateClothe(Clothe clothe) {
       Clothe clotheDB= repoClothe.getClotheByReference(clothe.getReference());
       if(clotheDB==null){
           return new Clothe();
       }
       else{
          
           if(clothe.getCategory()==null){
               clothe.setCategory(clotheDB.getCategory());
           }
           if(clothe.getSize()==null){
               clothe.setSize(clotheDB.getSize());
           }
           if(clothe.getDescription()==null){
               clothe.setDescription(clotheDB.getDescription());
           }
           if(clothe.isAvailability()){
               clothe.setAvailability(clotheDB.isAvailability());
           }
           if(clothe.getPhotography()==null){
               clothe.setPhotography(clotheDB.getPhotography());
           }
           return repoClothe.save(clothe);
       }    
    }

    public void deleteClothe(String id) {
        repoClothe.deleteClothe(id);
    }

    public List<Clothe> deleteAll() {
        repoClothe.deletAll();
        List<Clothe> list =new ArrayList<Clothe>();            
        return list ;
    }
    public Clothe getClotheById(String id){
        return repoClothe.getClotheById(id);
    }

    public List<Clothe> getClotheByDescription(String des) {
        return repoClothe.getClotheByDescription(des);
    }

    public List<Clothe> getClotheByPrice(Integer price) {
return repoClothe.getClotheByPrice(price);   } 
}
