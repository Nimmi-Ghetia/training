/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.springsecuritydemo;

/**
 *
 * @author nimmi
 */
public interface UserDao {
    
    public User retrieveUser(String username);
}
