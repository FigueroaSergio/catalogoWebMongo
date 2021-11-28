/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.catalogo.catalogo.Repositories;

import com.catalogo.catalogo.Entities.User;
import com.catalogo.catalogo.Interfaces.UserInterface;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author figue
 */
@Repository
public class UserRepository {
    @Autowired
    private UserInterface crud1;
    public List<User> getAll(){
	        return (List<User>) crud1.findAll();
	    }
    public User save(User user){
	        return crud1.save(user);
	    }
    public boolean deleteUser(int id){
	        Optional<User> userDB= crud1.findById(id);
                if(userDB.isPresent()){
                    crud1.deleteById(id);
                    return true;
                }else{
                   return false;
                }
	    }
    public User getUserByID(int id){
        return crud1.findById(id).orElse(null);
    }

    public User userEmailExist(String email) {
            User userDB= crud1.getUserByEmail(email).orElse(null);   
            return userDB;
    }

    public User getUserByEmailAndPassword(String email, String password) {
        User userDB= crud1.getUserByEmailAndPassword(email,password);   
        if(userDB!=null){
            return userDB;
        }
        else{
            return new User();
        }
    }

    public void deleteAll() {
        crud1.deleteAll();
    }
}
