package com.vektorel.IlkSpring.mvccontroller;

import com.vektorel.IlkSpring.repository.entity.Slider;
import com.vektorel.IlkSpring.service.SliderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("/slider")
public class SliderController {
    @Autowired
    SliderService sliderService;

    @GetMapping("/demo")
    public  String demo(){
        sliderService.save(
                Slider.builder()
                        .ad("bir")
                        .anabaslik("Yıl başı kampanyası")
                        .altbaslik("ödüller cepte")
                        .aciklama("skdfsdlfsl dslkdslkfjdslk fldslkfjdjldsf lk jdslkjflksdf kljdf lkjsd lkjds")
                        .butontext("Haydi Katıl")
                        .buttonlink("/kampanyalar/yilbasi")
                        .resimurl("images/home/girl1.jpg")
                        .status(1)
                        .startdate(new Date().getTime()-(1000*10))
                        .enddate(new Date().getTime()+(1000*40))
                        .build()
        );
        return "redirect:/";
    }
}
