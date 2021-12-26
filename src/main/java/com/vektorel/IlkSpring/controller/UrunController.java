package com.vektorel.IlkSpring.controller;

import com.vektorel.IlkSpring.dto.request.UrunRequestDto;
import com.vektorel.IlkSpring.repository.entity.Urun;
import com.vektorel.IlkSpring.service.UrunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
// Request-> İstek | Mapping -> gelen isteğin karşılanma şekli
// localhost/urun -> şeklinde gelen isteğin bu class tarafından karşılanmasını sağlar
@RequestMapping("/urun")
public class UrunController {

    @Autowired
    UrunService urunService;
    // localhost:9090/urun/addurun
    @GetMapping("/addurun")
    public ResponseEntity<Void> addUrun(){
        urunService.save(Urun.builder().ad("Bilgisayar").fiyat(25000).state(1).build());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/updateurun")
    public void saveUrun(){
        urunService.update(Urun.builder().id(2L).ad("Monitör").fiyat(3600).state(1).build());
    }

    @GetMapping("/getbyid")
    public ResponseEntity<Urun> getById(long id){
        return ResponseEntity.ok(urunService.getById(id));
    }

    @GetMapping("/findbyid")
    public ResponseEntity<Urun> findById(long id){
        return ResponseEntity.ok(urunService.findById(id));
    }

    @GetMapping("/findbyfiyat")
    public ResponseEntity<List<Urun>> findByFiyat(double fiyat){
        return ResponseEntity.ok(urunService.getUpperPrice(fiyat));
    }

    @GetMapping("/deleteurun")
    public ResponseEntity<String> deleteUrun(long id){
        try {
            urunService.delete(id);
            return ResponseEntity.ok("Ok");
        }catch (Exception e){
            return ResponseEntity.ok("Hata..: "+e.toString());
        }

    }

    // Burada ki değerler HTTP üzerinde algılanan istek çeşitleridir
    // POST, PUT, DELETE, GET
    // http:localhost/urun/save
    @PostMapping("/save")
    public ResponseEntity<String> save(String ad, double fiyat,String aciklama,int kdv){
        urunService.save(
                Urun.builder().ad(ad).fiyat(fiyat).aciklama(aciklama).kdv(kdv).build()
        );
        return ResponseEntity.ok("Ok");
    }

    @PostMapping("/saveurun")
    public ResponseEntity<Void> save(Urun urun){
        urunService.save(urun);
        return  ResponseEntity.ok().build();
    }

    public ResponseEntity<Void> save(UrunRequestDto dto){
        return  ResponseEntity.ok().build();
    }

    //localhost:9090/urun/getall
    @GetMapping("/niyegeldinarkadas")
    public ResponseEntity<List<Urun>> getall(){
      return ResponseEntity.ok(urunService.findAll());
    }

    @GetMapping("/sayfa")
    public String sayfa(){
        return "<p style='backgroud-color:red'> Merhaba Arkadaşlar</p>";
    }
}
