package com.vektorel.IlkSpring.modelpages;

import com.vektorel.IlkSpring.repository.entity.Categories;
import com.vektorel.IlkSpring.repository.entity.Urun;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CategoryUrunModel {

    Categories categories;
    List<Urun> urunlist;
}
