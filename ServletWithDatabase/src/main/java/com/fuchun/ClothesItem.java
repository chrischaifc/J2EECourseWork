package com.fuchun;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//this class is for cloth entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class ClothesItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Type type;
    private String color;
    private double price;

}
