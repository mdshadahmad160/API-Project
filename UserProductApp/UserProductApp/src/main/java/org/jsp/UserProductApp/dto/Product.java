package org.jsp.UserProductApp.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name, brand, category, description;
    private double cost;
    private String image;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
