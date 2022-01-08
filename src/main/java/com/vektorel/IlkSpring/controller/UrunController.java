package com.vektorel.IlkSpring.controller;

import static com.vektorel.IlkSpring.constants.RestApiUrls.*;
import com.vektorel.IlkSpring.dto.request.UrunRequestDto;
import com.vektorel.IlkSpring.dto.response.UrunResponseDto;
import com.vektorel.IlkSpring.repository.entity.Urun;
import com.vektorel.IlkSpring.service.UrunService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
// Request-> İstek | Mapping -> gelen isteğin karşılanma şekli
// localhost/urun -> şeklinde gelen isteğin bu class tarafından karşılanmasını sağlar
@RequestMapping(VERSION+URUNCONTROLLER)
@Api(value = "urunkontroller")
public class UrunController {

    @Autowired
    UrunService urunService;

    // Urun-> 20 adet özellik
    // UrunResponseDto-> 4 alan var
    // Dto(Data Transfer Object)->
    // Direkt Entity nin kullanımı performans sorunlarına yol açar.
    @GetMapping("/findallurunresponse")
    public ResponseEntity<List<UrunResponseDto>> findAllUrun(){
        return ResponseEntity.ok(urunService.findAllUrunResponse());
    }


    // localhost:9090/urun/addurun
    @ApiOperation(value = "ürün ekleme")
    @GetMapping(URUNCONTROLLER_ADDURUN)
    public ResponseEntity<Void> addUrun(){
        urunService.save(Urun.builder().ad("Bilgisayar").fiyat(25000).state(1).build());
        return ResponseEntity.ok().build();
    }
    @ApiOperation(value = "ürün katdetme")
    @GetMapping(UPDATE)
    public void saveUrun(){
        urunService.update(Urun.builder().id(2L).ad("Monitör").fiyat(3600).state(1).build());
    }
    @ApiOperation(value = "id den ürün bulmak")
    @GetMapping("/getbyid")
    public ResponseEntity<Urun> getById(long id){
        return ResponseEntity.ok(urunService.getById(id));
    }
    @ApiOperation(value = "id den ürün bulmak..")
    @GetMapping(FINDBYID)
    public ResponseEntity<Urun> findById(long id){
        return ResponseEntity.ok(urunService.findById(id));
    }
    @ApiOperation(value = "fiyatından ürünleri bulmak")
    @GetMapping("/findbyfiyat")
    public ResponseEntity<List<Urun>> findByFiyat(double fiyat){
        return ResponseEntity.ok(urunService.getUpperPrice(fiyat));
    }
    @ApiOperation(value = "ürün silme")
    @GetMapping(DELETE)
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
    @PostMapping(SAVE)
    @ApiOperation(value = "ürün kaydetme")
    public ResponseEntity<String> save(String ad, double fiyat,String aciklama,int kdv){
        urunService.save(
                Urun.builder().ad(ad).fiyat(fiyat).aciklama(aciklama).kdv(kdv).build()
        );
        return ResponseEntity.ok("Ok");
    }
    @ApiOperation(value = "ürün ekleme-1")
    @PostMapping("/saveurun")
    public ResponseEntity<Void> save(Urun urun){
        urunService.save(urun);
        return  ResponseEntity.ok().build();
    }

    public ResponseEntity<Void> save(UrunRequestDto dto){
        return  ResponseEntity.ok().build();
    }

    @ApiOperation(value = "tüm ürünleri listele")
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
