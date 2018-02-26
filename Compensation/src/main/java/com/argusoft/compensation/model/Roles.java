/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.compensation.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
//@Embeddable
public class Roles {
    @Id
    private int id;
//    private int user_id;
    private String role;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Role{" + "id=" + id + ", role=" + role + '}';
    }

//    public int getUser_id() {
//        return user_id;
//    }
//
//    public void setUser_id(int user_id) {
//        this.user_id = user_id;
//    }
//
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
}

