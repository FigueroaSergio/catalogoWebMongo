/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.catalogo.catalogo.Repositories;

import com.catalogo.catalogo.Entities.Clothe;
import com.catalogo.catalogo.Interfaces.ClotheInterface;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author figue
 */
@Repository
public class ClotheRepository {
    @Autowired
    private ClotheInterface crud2;
    public List<Clothe> getAll(){
	        return (List<Clothe>) crud2.findAll();
	    }
   public Clothe save(Clothe clothe){
	        return crud2.save(clothe);
	    }

    public Clothe getClotheByReference(String reference) {
        return crud2.findById(reference).orElse(null);
    }
    public boolean deleteClothe(String id){
	        Optional<Clothe> clotheDB= crud2.findById(id);
                if(clotheDB.isPresent()){
                    crud2.deleteById(id);
                    return true;
                }else{
                   return false;
                }
	    }

    public void deletAll() {
         crud2.deleteAll();
    }
    
    public Clothe getClotheById(String id){
	        return crud2.findById(id).orElse(null);
	    }

    
}
