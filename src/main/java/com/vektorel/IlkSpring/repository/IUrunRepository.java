package com.vektorel.IlkSpring.repository;

// Srping Data JPA -> bu interface referans alınır.

import com.vektorel.IlkSpring.repository.entity.Urun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

// DİKKAT: repository sınıfını işaretlemek için sınıf üzerine annotiaon eklenmelidir.
@Repository
public interface IUrunRepository extends JpaRepository<Urun,Long> {
    // select * from tblurun where fiyat>???
   List<Urun> findByFiyatGreaterThan(double fiyat);
    // select * from tblrunu where state=??
   List<Urun> findByStateEquals(int state);
    // select * from tblurun where fiyat>?? and state=??
   List<Urun> findByFiyatGreaterThanAndStateEquals(double fiyat,int state);

   @Query("select * from tblurun")
   List<Urun> tumunugetirarkadas();


}
