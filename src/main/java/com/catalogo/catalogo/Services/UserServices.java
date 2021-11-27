/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.catalogo.catalogo.Services;

import com.catalogo.catalogo.Entities.User;
import com.catalogo.catalogo.Repositories.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author figue
 */
@Service
public class UserServices {
    @Autowired
    private UserRepository repoUser;
    public List<User> getAll() {
        return repoUser.getAll();
    }
    public User save(User user){
            return repoUser.save(user);
    }
    public void deleteUser(int id){
            repoUser.deleteUser(id);
    }

    public boolean userEmailExists(String email) {
        return repoUser.userEmailExist(email);
    }

    public User getUserByEmailAndPassword(String email, String password) {
        return repoUser.getUserByEmailAndPassword(email,password);
    }

    public User updateUser(User user) {
       User userDB= repoUser.getUserByID(user.getId());
       if(userDB==null){
           return new User();
       }
       else{
           return repoUser.save(user);
       }
    }

    public List<User> deleteAll() {
        repoUser.deleteAll();
        List<User> list =new ArrayList<User>(); 
        return list;
    }

    
}
