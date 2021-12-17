/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.catalogo.catalogo.Controllers;

import com.catalogo.catalogo.Entities.Clothe;
import com.catalogo.catalogo.Entities.User;
import com.catalogo.catalogo.Services.ClotheService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author figue
 */
@RestController
@RequestMapping("/api/clothe")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ClotheController {
    @Autowired
    private ClotheService servicio;
    @GetMapping("/all")
    public List<Clothe> getClothe(){
        return servicio.getAll();
    }
    @GetMapping("/{id}")
    public Clothe getClothe(@PathVariable("id") String id){
        return servicio.getClotheById(id);
    }
    @GetMapping("/description/{des}")
    public List<Clothe> getClotheByDescription(@PathVariable("des") String des){
        return servicio.getClotheByDescription(des);
    }
    @GetMapping("/price/{price}")
    public List<Clothe> getClotheByPrice(@PathVariable("price") Integer price){
        return servicio.getClotheByPrice(price);
    }
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Clothe save(@RequestBody Clothe clothe) {
        return servicio.save(clothe);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Clothe updateUser(@RequestBody Clothe clothe) {
         return servicio.updateClothe(clothe);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("id") String id) {
         servicio.deleteClothe(id);
    }
    @DeleteMapping("/all")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public List<Clothe> deleteAll() {
         return servicio.deleteAll();
    }
}
