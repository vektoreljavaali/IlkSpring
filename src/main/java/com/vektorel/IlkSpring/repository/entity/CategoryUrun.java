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
@Table(name = "tblcategoryurun")
@Entity
public class CategoryUrun {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    long categoryid;
    long urunid;
    int state;
}
