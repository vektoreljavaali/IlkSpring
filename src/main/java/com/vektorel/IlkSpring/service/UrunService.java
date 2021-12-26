package com.vektorel.IlkSpring.service;

import com.vektorel.IlkSpring.repository.IUrunRepository;
import com.vektorel.IlkSpring.repository.entity.Urun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// DİKKAT: bir sınıfın servis olduğunu spring e bildirmek içni annotiation eklenir.
@Service
public class UrunService {

    // Gerekli olduğu zaman spring nesne oluşturmak üzere araya girer.
    // Nesne türetilmek istenilen sınıfın üzerine Atutowired annotiasyonu eklenir.
    @Autowired
    IUrunRepository repository;
    // Kaydetme -> Burada önemli olan bir nokta var, Id bilgirini girmemelisiniz
    public void save(Urun urun){
        repository.save(urun);
    }
    // güncelle -> Eğer bir nesne içinde Id bilgisi var ise o kayıt tekrar
    // katdedilmez güncellenir.
    public void update(Urun urun){
        repository.save(urun);
    }


    public void delete(long id){
        repository.deleteById(id);
    }

    // tüm kayıtları döner.
    // DİKKAT: tüm verilerin çekilde ortamlarda tabloların boyutları
    // gözönünde bulundurulmalıdır. her tabloya findall yapmayın
    public List<Urun> findAll(){
        return repository.findAll();
    }

    public Urun getById(long id){
        Urun urun = repository.getById(id);
        return urun;
    }

    public Urun findById(long id){
        // Optional -> Kapsadığı nesnenin verlığını kontrol ederek true/false değer dönebilir
        Optional<Urun> urun = repository.findById(id);
        // Eğer urun bilgisi null (boş ise)
        if(urun.isEmpty())
            return new Urun();
        // Eğer ürün bilgisi var ise o zaman optional içinde bulunan nesneyi getir.
        return urun.get();
    }

    public List<Urun> getUpperPrice(double fiyat){
        List<Urun> urunList = repository.findByFiyatGreaterThan(fiyat);
        return urunList;
    }
}
