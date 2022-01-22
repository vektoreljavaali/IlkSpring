package com.vektorel.IlkSpring.repository;

import com.vektorel.IlkSpring.repository.entity.UrunResimleri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UrunResimleriRepository extends JpaRepository<UrunResimleri,Long> {

    List<UrunResimleri> findByUrunidAndState(long urunid, int state);
}
