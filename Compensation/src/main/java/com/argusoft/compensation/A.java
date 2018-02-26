/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.compensation;

import java.lang.reflect.Field;

class B {
    private int x = 2;
}

public class A {

    public static void main(String[] args) throws Exception {
        Field f = B.class.getDeclaredField("x");
        f.setAccessible(true);
        f.get(new B());
        B b=new B();
        f.setInt(b,4);
        System.out.println(f.get(b));
    }
}