/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.catalogo.catalogo.Services;

import com.catalogo.catalogo.Entities.Clothe;
import com.catalogo.catalogo.Entities.User;
import com.catalogo.catalogo.Repositories.ClotheRepository;
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
    public List<Clothe> getAll() {
        return repoClothe.getAll();
    }
    public Clothe save(Clothe clothe){
            return repoClothe.save(clothe);
    }

    public Clothe updateClothe(Clothe clothe) {
       Clothe clotheDB= repoClothe.getClotheByReference(clothe.getReference());
       if(clotheDB==null){
           return new Clothe();
       }
       else{
           return repoClothe.save(clothe);
       }    
    }

    public void deleteClothe(String id) {
        repoClothe.deleteClothe(id);
    }
}
