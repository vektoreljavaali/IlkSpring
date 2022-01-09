package com.vektorel.IlkSpring.controller;

import com.vektorel.IlkSpring.repository.IUserRepository;
import com.vektorel.IlkSpring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public ModelAndView loginPage(){
        ModelAndView model = new ModelAndView();
        model.setViewName("login");
        return model;
    }

    @PostMapping("/login")
    public Object loginPage(String username,String password){
        boolean islogin = userService.isPassword(username, password);
        ModelAndView model = new ModelAndView();
        if(islogin)
            return "redirect:/";
        else{
            model.addObject("error","Kullanıc adı ve ya şifre yalıştır");
            model.setViewName("/login");
        }

        return model;
    }

}
