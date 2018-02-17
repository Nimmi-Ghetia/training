package com.argusoft.springsecuritydemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    
    
@RequestMapping(value="/",method=RequestMethod.GET)
public ModelAndView defaultmethod(){
    System.out.println("\n\n\n\nindex");
    return new ModelAndView("index");
}

@RequestMapping(value="/welcome",method=RequestMethod.GET)
public ModelAndView printwelcome(){
   
    return new ModelAndView("welcome","message","Helloooooooooooo");
}
    
}
