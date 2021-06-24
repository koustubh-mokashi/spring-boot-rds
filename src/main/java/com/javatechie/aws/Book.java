package com.javatechie.aws;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Book")
public class Book {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private double price;
}
