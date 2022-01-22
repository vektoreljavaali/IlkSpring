package com.vektorel.IlkSpring.service;

import com.vektorel.IlkSpring.controller.UrunController;
import com.vektorel.IlkSpring.modelpages.CategoryUrunModel;
import com.vektorel.IlkSpring.repository.CategoryUrunRepository;
import com.vektorel.IlkSpring.repository.ICategories;
import com.vektorel.IlkSpring.repository.IUrunRepository;
import com.vektorel.IlkSpring.repository.entity.Categories;
import com.vektorel.IlkSpring.repository.entity.CategoryUrun;
import com.vektorel.IlkSpring.repository.entity.Urun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryUrunService {

    @Autowired
    CategoryUrunRepository repository;

    @Autowired
    ICategories categories;

    @Autowired
    IUrunRepository iUrunRepository;

    public void save(CategoryUrun item){
        repository.save(item);
    }
    public void update(CategoryUrun item){
        repository.save(item);
    }
    public void delete(CategoryUrun item){
        repository.delete(item);
    }
    public List<CategoryUrun> findByCategoryId(long categoryid){
        return repository.findByCategoryidAndState(categoryid,1);
    }

    public List<CategoryUrunModel> findCategoryUrunList(){
        // Özelleştirilmiş sayfa için uyarlanmış özel görünüm sınıfı
        List<CategoryUrunModel> models = new ArrayList<>();
        for (Categories itemC: categories.findAll()) {
            List<Urun> urunList = new ArrayList<>();
            // Öncelikle Kategori Listesini Çekiyoruz.
            // İlgili kategoriye ait ürün listesini CategoryUrun listesi içinden listeliyoruz
            // sonra id sini bulduğumuz ürünü ürün listesi içinde UrunRespository den alarak ekliyoruz.
            for (CategoryUrun itemCU: repository.findByCategoryidAndState(itemC.getId(), 1)) {
                urunList.add(
                        iUrunRepository.findById(itemCU.getUrunid()).get()
                );
            }
            models.add(
                CategoryUrunModel.builder()
                        .categories(itemC)
                        .urunlist(urunList)
                        .build()
            );
        }
        return models;
    }

}
