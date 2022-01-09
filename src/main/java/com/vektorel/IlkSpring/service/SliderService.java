package com.vektorel.IlkSpring.service;

import com.vektorel.IlkSpring.repository.ISliderRepository;
import com.vektorel.IlkSpring.repository.entity.Slider;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SliderService {

    @Autowired
    ISliderRepository iSliderRepository;

    public Slider save(Slider item){
        iSliderRepository.save(item);
        return item;
    }
    public Slider update(Slider item){
        iSliderRepository.save(item);
        return item;
    }
    public boolean delete(Slider item){
        try {
            iSliderRepository.delete(item);
            return true;
        }catch (Exception e){
            return false;
        }

    }
    public List<Slider> findAll(){
       return iSliderRepository.findAll();

    }
    public List<Slider> findAllActive(){
        long nowdate = new Date().getTime();
        List<Slider> list = iSliderRepository
                .findByStartdateLessThanAndEnddateGreaterThanAndStatusEquals(
                        nowdate,nowdate,1
                );
        return list;
    }

}
