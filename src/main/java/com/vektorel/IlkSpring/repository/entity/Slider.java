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
@Table(name = "tblslider")
@Entity
public class Slider {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String ad;
    String resimurl;
    String anabaslik;
    String altbaslik;
    String aciklama;
    String butontext;
    String buttonlink;
    long startdate;
    long enddate;
    int status;
}
