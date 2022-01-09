package com.vektorel.IlkSpring.repository;

import com.vektorel.IlkSpring.repository.entity.Slider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISliderRepository extends JpaRepository<Slider,Long> {

    List<Slider> findByStartdateLessThanAndEnddateGreaterThanAndStatusEquals(long startdate,long enddate,int status);

}
