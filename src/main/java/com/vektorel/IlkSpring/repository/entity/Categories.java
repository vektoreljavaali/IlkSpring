package com.vektorel.IlkSpring.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tblcategories")
@Entity
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    long parentid;
    String ad;
    String url;
    String aciklama;
    String kategoriurl;
    /**
     * 1- aktif
     * 0- pasif
     */
    int status;
}
