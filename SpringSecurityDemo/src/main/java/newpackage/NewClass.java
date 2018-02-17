/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
/**
 *
 * @author nimmi
 */
public class NewClass {
    public static void main(String[] args) {
//        BCrypt b = new BCrypt();
//        System.out.println(b.encode("123"));
BCryptPasswordEncoder b= new BCryptPasswordEncoder();
        System.out.println(b.encode("123"));
    }
}
