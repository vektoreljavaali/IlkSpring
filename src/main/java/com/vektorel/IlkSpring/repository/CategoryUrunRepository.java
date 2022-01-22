package com.vektorel.IlkSpring.repository;

import com.vektorel.IlkSpring.repository.entity.CategoryUrun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryUrunRepository extends JpaRepository<CategoryUrun,Long> {

    List<CategoryUrun> findByCategoryidAndState(long categoryid,int state);
}
