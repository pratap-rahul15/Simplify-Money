// Entity class for Purchase.

package com.simplifymoney.insurance_api.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "purchases")
@Data
@NoArgsConstructor
// @AllArgsConstructor
@ToString
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // id of the purchase.

    @ManyToOne
    @JoinColumn(name = "insurance_id", nullable = false)
    private Insurance insurance;   //  each purchase is linked to an insurance plan manyToOne relationship.

    @Column(nullable = false)
    private String buyerName;  // insurance purchaser name

    @Column(nullable = false)
    private String buyerEmail;  // purchaser e-mail

    @Column(nullable = false)
    private LocalDateTime purchaseDate;  // purchase date

    public Purchase(Long id, Insurance insurance, String buyerName, String buyerEmail, LocalDateTime purchaseDate) {
        this.id = id;
        this.insurance = insurance;
        this.buyerName = buyerName;
        this.buyerEmail = buyerEmail;
        this.purchaseDate = purchaseDate;
    }

}
