package com.vektorel.IlkSpring.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tblurun")
@Entity
public class Urun {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String ad;
    String aciklama;
    double fiyat;
    int miktar;
    int kdv;
    double kdvfiyat;
    int state; // 0-pasif kayıt 1-aktif kayıt
}
