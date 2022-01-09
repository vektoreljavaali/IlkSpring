package com.vektorel.IlkSpring.controller;

import com.vektorel.IlkSpring.repository.entity.Categories;
import com.vektorel.IlkSpring.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categori")
public class Categorycontroller {

     @Autowired
     CategoriesService categoriesService;

     @GetMapping("/demo")
     public String demoCategori(){
          categoriesService.save(
                  Categories.builder()
                          .ad("Bilgisayar")
                          .kategoriurl("/bilgisayar")
                          .parentid(0)
                          .status(1)
                          .url("/images/categories.png")
                          .build()
          );
          categoriesService.save(
                  Categories.builder()
                          .ad("Ev, Yaşam")
                          .kategoriurl("/evyasam")
                          .parentid(0)
                          .status(1)
                          .url("/images/evyasam.png")
                          .build()
          );
          categoriesService.save(
                  Categories.builder()
                          .ad("Spor")
                          .kategoriurl("/spor")
                          .parentid(0)
                          .status(1)
                          .url("/images/spor.png")
                          .build()
          );
          categoriesService.save(
                  Categories.builder()
                          .ad("Beyaz Eşya")
                          .kategoriurl("/beyazesya")
                          .parentid(0)
                          .status(1)
                          .url("/images/beyazesya.png")
                          .build()
          );
          return "return:/";
     }
}
