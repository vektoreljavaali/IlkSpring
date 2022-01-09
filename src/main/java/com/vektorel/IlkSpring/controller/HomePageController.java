package com.vektorel.IlkSpring.controller;

import com.vektorel.IlkSpring.service.CategoriesService;
import com.vektorel.IlkSpring.service.SliderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomePageController {

    @Autowired
    CategoriesService categoriesService;
    @Autowired
    SliderService sliderService;

    @GetMapping("/")
    public ModelAndView Index(){
        ModelAndView model = new ModelAndView();
        model.addObject("categories",categoriesService.findAllParents());
        model.addObject("sliderlist",sliderService.findAllActive());
        model.setViewName("index");
        return model;
    }
}
