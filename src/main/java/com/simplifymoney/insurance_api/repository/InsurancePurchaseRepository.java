package com.simplifymoney.insurance_api.repository;

import com.simplifymoney.insurance_api.model.InsurancePurchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsurancePurchaseRepository extends JpaRepository<InsurancePurchase, Long> {

}
