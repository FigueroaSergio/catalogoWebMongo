/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.catalogo.catalogo.Entities;

import java.util.Date;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author figue
 */
@Document(collection = "orders")

@Data

@NoArgsConstructor

@AllArgsConstructor

public class Order {
    @Transient
    public static final String SEQUENCE_NAME = "orders_sequence";
    
    public static String PENDING = "Pendiente";

    public static String APROVED = "Aprobada";

    public static String REJECTED = "Rechazada";

    @Id

    private Integer id;

    private Date registerDay;

    private String status;

    private User salesMan;

    private Map<String, Clothe> products;

    private Map<String, Integer> quantities;

    public static String getPENDING() {
        return PENDING;
    }

    public static void setPENDING(String PENDING) {
        Order.PENDING = PENDING;
    }

    public static String getAPROVED() {
        return APROVED;
    }

    public static void setAPROVED(String APROVED) {
        Order.APROVED = APROVED;
    }

    public static String getREJECTED() {
        return REJECTED;
    }

    public static void setREJECTED(String REJECTED) {
        Order.REJECTED = REJECTED;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getRegisterDay() {
        return registerDay;
    }

    public void setRegisterDay(Date registerDay) {
        this.registerDay = registerDay;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getSalesMan() {
        return salesMan;
    }

    public void setSalesMan(User salesMan) {
        this.salesMan = salesMan;
    }

//    public <any> getProducts() {
//        return products;
//    }
//
//    public void setProducts(<any> products) {
//        this.products = products;
//    }
//
//    public <any> getQuantities() {
//        return quantities;
//    }
//
//    public void setQuantities(<any> quantities) {
//        this.quantities = quantities;
//    }
    
    

}

