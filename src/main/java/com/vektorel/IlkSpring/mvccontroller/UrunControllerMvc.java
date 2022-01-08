package com.vektorel.IlkSpring.mvccontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UrunControllerMvc {

    @GetMapping("/homepage")
    public ModelAndView HomePage(){
        ModelAndView model = new ModelAndView();
        model.addObject("title","MVC Ana Sayfası Tekrar Deneyelim");
        model.setViewName("homepage");
        return model;
    }
}
