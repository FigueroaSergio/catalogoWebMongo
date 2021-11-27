/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.catalogo.catalogo.Controllers;

import com.catalogo.catalogo.Entities.User;
import com.catalogo.catalogo.Services.UserServices;
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
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class UserController {
    @Autowired
    private UserServices servicio;
    @GetMapping("/all")
    public List<User> getUsers(){
        return servicio.getAll();
    }
    @GetMapping("/{email}/{password}")
    public User userEmailExist(@PathVariable("email") String email,@PathVariable("password") String password){
        return servicio.getUserByEmailAndPassword(email,password);
    }
    @GetMapping("/emailexist/{email}")
    public boolean userEmailExist(@PathVariable("email") String email){
        return servicio.userEmailExists(email);
    }
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user) {
        return servicio.save(user);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User updateUser(@RequestBody User user) {
         return servicio.updateUser(user);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void deleteUser(@PathVariable("id") int id) {
         servicio.deleteUser(id);
    }
    @DeleteMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    public List<User> deleteUser() {
         return servicio.deleteAll();
    }
}
