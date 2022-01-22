package com.vektorel.IlkSpring.controller;

import static com.vektorel.IlkSpring.constants.RestApiUrls.*;

import com.vektorel.IlkSpring.repository.entity.CategoryUrun;
import com.vektorel.IlkSpring.service.CategoryUrunService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(VERSION+CATEGORYURUN)
@Api(value = "categoryurun")
public class CategoryUrunController {

    @Autowired
    CategoryUrunService categoryUrunService;

    @PostMapping("/save")
    public ResponseEntity<String> save(long categoryid, long urunid){
        categoryUrunService.save(
                CategoryUrun.builder()
                        .categoryid(categoryid)
                        .urunid(urunid)
                        .state(1)
                        .build()
        );
        return ResponseEntity.ok("İşlem Başarılı");
    }
}
