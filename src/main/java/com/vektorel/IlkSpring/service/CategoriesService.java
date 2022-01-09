package com.vektorel.IlkSpring.service;

import com.vektorel.IlkSpring.repository.ICategories;
import com.vektorel.IlkSpring.repository.entity.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesService {

    @Autowired
    ICategories iCategories;

    public Categories save(Categories item){
        iCategories.save(item);
        return item;
    }

    public Categories update(Categories item){
        iCategories.save(item);
        return item;
    }

    public boolean delete(Categories item){
        try {
            iCategories.delete(item);
            return true;
        }catch (Exception exception){
            return false;
        }
    }

    public List<Categories> findAll(){
        return iCategories.findAll();
    }
    public List<Categories> findAllParents(){
        return iCategories.findByParentidEquals(0L);
    }
}
