package com.vektorel.IlkSpring.controller;

import static com.vektorel.IlkSpring.constants.RestApiUrls.*;

import com.vektorel.IlkSpring.repository.entity.Urun;
import com.vektorel.IlkSpring.repository.entity.UrunResimleri;
import com.vektorel.IlkSpring.service.UrunResimleriService;
import com.vektorel.IlkSpring.service.UrunService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@RestController
@RequestMapping(VERSION+URUNRESIMCONTROLLER)
@Api(value = "UrunResimController")
public class UrunResimController {

    @Autowired
    UrunResimleriService urunResimleriService;

    @Autowired
    UrunService urunService;

    @PostMapping("/save")
    @ApiOperation(value = "ürün resim ekleme ekleme")
    public ResponseEntity<String> saveImage(long urunid, MultipartFile file){
        // NOT!!! her bir dosya için özel uniqId oluşturmak kontrol için
        // daha iyi oluyor.
        String filename = UUID.randomUUID().toString();
    try {
       Urun urun =  urunService.findById(urunid);
       if(urun.getId()!=0){
           File localfile = new File("C:\\inetpub\\wwwroot\\img\\"+filename+".png");
           file.transferTo(localfile);
           urunResimleriService.save(
                   UrunResimleri.builder().ad(filename)
                           .url("http://localhost/img/"+filename+".png")
                           .urunid(urunid)
                           .build()
           );
           return ResponseEntity.ok("İşlem Tamam");
       }else{
           return ResponseEntity.ok("Id si girilen ürün Bulunamadı");
       }

    }catch (Exception ex){
        return ResponseEntity.ok("Hata Oluştu..: "+ ex.toString());
    }

    }
}
