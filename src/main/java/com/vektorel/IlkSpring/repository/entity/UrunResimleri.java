package com.vektorel.IlkSpring.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "tblurunresimleri")
@Entity
public class UrunResimleri {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    long urunid;
    String url;
    String ad;
    int state;
}
