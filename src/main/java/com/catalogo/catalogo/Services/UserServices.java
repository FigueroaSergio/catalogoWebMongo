/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.catalogo.catalogo.Services;

import com.catalogo.catalogo.Entities.DatabaseSequence;
import com.catalogo.catalogo.Entities.User;
import com.catalogo.catalogo.Repositories.UserRepository;
import static com.mongodb.client.model.Filters.where;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import org.springframework.data.mongodb.core.MongoOperations;
import static org.springframework.data.mongodb.core.query.Query.query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

/**
 *
 * @author figue
 */
@Service
public class UserServices {
    @Autowired
    private UserRepository repoUser;
    @Autowired
    private generateSequence sequenceGenerator;
    public List<User> getAll() {
        return repoUser.getAll();
    }
    public User save(User user){  
        if(user.getId()==null){
             user.setId(sequenceGenerator.generateSequence(User.SEQUENCE_NAME));

        }
        
        return repoUser.save(user);                      
    }
    public void deleteUser(int id){
            repoUser.deleteUser(id);
    }

    public boolean userEmailExists(String email) {
        if(repoUser.userEmailExist(email)==null){
            return false;
        }else{
        return true;
        }
    }

    public User getUserByEmailAndPassword(String email, String password) {
        return repoUser.getUserByEmailAndPassword(email,password);
    }

    public User updateUser(User user) {
       User userDB= repoUser.getUserByID(user.getId());
       if(userDB==null ){
           return new User();
       }
       userDB= repoUser.userEmailExist(user.getEmail());
       if(userDB!=null && !Objects.equals(userDB.getId(), user.getId())){
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

    public User getUser(int id) {
        return repoUser.getUserByID(id);
    }

    
}
