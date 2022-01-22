package com.vektorel.IlkSpring.service;

import com.vektorel.IlkSpring.repository.UrunResimleriRepository;
import com.vektorel.IlkSpring.repository.entity.UrunResimleri;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrunResimleriService {

    @Autowired
    UrunResimleriRepository repository;

    public void save(UrunResimleri item){
        repository.save(item);
    }
    public void update(UrunResimleri item){
        repository.save(item);
    }
    public void delete(UrunResimleri item){
        repository.save(item);
    }
    public List<UrunResimleri> findAllByUrunId(long urunid){
        return repository.findByUrunidAndState(urunid,1);
    }

}
