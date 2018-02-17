package com.argusoft.springsecuritydemo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author nimmi
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    UserDaoImpl userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.argusoft.springsecuritydemo.User u=userDao.retrieveUser(username);
        
        
        List<SimpleGrantedAuthority> authList = new ArrayList<>();
        
        authList.add(new SimpleGrantedAuthority(u.getRole()));
        UserDetails u1 = new org.springframework.security.core.userdetails.User(username,u.getPassword() , true, true, true, true, authList);

        //UserDetails user = new org.springframework.security.core.userdetails.User(username, "$2a$10$9BSR.4hNl.s497NsTnBNTu31MIBi1F4xlAnbyCo0frcBDgAhGu1zC", true, true, true, true, new GrantedAuthority[]{ new GrantedAuthorityImpl("ROLE_USER") });
        return u1;
    }
}
