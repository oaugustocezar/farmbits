package com.example.farmbits.model;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")

public class Product implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProduct")
    private long idProduct;
    @Column(name = "productName")
    private String productName;
    @Column(name = "description")
    private String description;
    @Column (name = "price")
    private Double price;
    @Column (name = "discount")
    private Double discount;
    @ManyToOne
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    private Category category;
    @ManyToMany()
    @JoinTable(name = "product_provider",
            joinColumns = { @JoinColumn(name = "fk_product") },
            inverseJoinColumns = { @JoinColumn(name = "fk_provider") })
    private List<Provider> providers;
}
