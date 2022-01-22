package com.vektorel.IlkSpring.mvccontroller;

import com.vektorel.IlkSpring.repository.entity.Urun;
import com.vektorel.IlkSpring.service.CategoriesService;
import com.vektorel.IlkSpring.service.CategoryUrunService;
import com.vektorel.IlkSpring.service.SliderService;
import com.vektorel.IlkSpring.service.UrunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomePageController {

    @Autowired
    CategoriesService categoriesService;
    @Autowired
    SliderService sliderService;
    @Autowired
    UrunService urunService;
    @Autowired
    CategoryUrunService categoryUrunService;

    @GetMapping("/")
    public ModelAndView Index(){
        ModelAndView model = new ModelAndView();
        model.addObject("categories",categoriesService.findAllParents());
        model.addObject("sliderlist",sliderService.findAllActive());
        List<Urun> urunlistesi = urunService.findAll();
        model.addObject("urunlist",urunlistesi);
        model.addObject("categoryurunlist",categoryUrunService.findCategoryUrunList());
        model.addObject("list1",urunService.findAll().subList(0,3));
        model.addObject("list2",urunService.findAll().subList(3,urunService.findAll().size()>6 ? 6 : urunService.findAll().size()));
        model.setViewName("index");
        return model;
    }
}
