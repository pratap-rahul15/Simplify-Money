package com.simplifymoney.insurance_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "insurance_purchases")
@AllArgsConstructor
public class InsurancePurchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "insurance_id", nullable = false)
    private Insurance insurance;

    @Column(nullable = false)
    private String buyerName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private LocalDateTime purchaseDate;

    @Column(nullable = false)
    private String policyDocumentUrl;

    public InsurancePurchase() {}

    public InsurancePurchase(Insurance insurance, String buyerName, String email) {
        this.insurance = insurance;
        this.buyerName = buyerName;
        this.email = email;
        this.purchaseDate = LocalDateTime.now();
        this.policyDocumentUrl = "/api/insurances/download-policy/" + insurance.getId();
    }

    public InsurancePurchase(Insurance insurance, String buyerName, String email, String policyDocumentUrl) {
    }

    public String getPolicyDocumentUrl() {
        return policyDocumentUrl;
    }

    public void setPolicyDocumentUrl(String policyDocumentUrl) {
        this.policyDocumentUrl = policyDocumentUrl;
    }

    public String getBuyerName() {
        return "";
    }

    public String getEmail() {
        return "";
    }
}
