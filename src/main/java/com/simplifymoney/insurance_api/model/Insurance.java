package com.simplifymoney.insurance_api.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "insurances")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // ID of the insurance

    @Column(nullable = false)
    private String name;  // Name of the insurance

    @Column(nullable = false)
    private String type;  // Type like - health, education, car, house, gold, life

    @Column(nullable = false)
    private Double price;  // Price of the insurance

    @Column(length = 500)
    private String description;  // Details about the insurance


    public Insurance(String name, String type, Double price, String description) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.description = description;
    }
}
