package com.vektorel.IlkSpring.repository;

import com.vektorel.IlkSpring.repository.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICategories extends JpaRepository<Categories,Long> {

    List<Categories> findByParentidEquals(long id);
}
