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
@Table(name = "tblusers")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String username;
    String password;
    int questions;
    String answer;
    /**
     *  1- kullanıcı(Müşteri)
     *  2- personel
     *  3- admin
     *  4- süperadmin
     */
    int yetki;
    /**
     * 0- pasif hesap
     * 1- aktif hesap
     * 2- onayda bekleyen
     * 3- dondorulmuş
     */
    int state;

}
