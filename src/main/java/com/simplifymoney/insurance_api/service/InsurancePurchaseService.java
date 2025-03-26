package com.simplifymoney.insurance_api.service;

import com.simplifymoney.insurance_api.model.Insurance;
import com.simplifymoney.insurance_api.model.InsurancePurchase;
import com.simplifymoney.insurance_api.repository.InsurancePurchaseRepository;
import com.simplifymoney.insurance_api.repository.InsuranceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InsurancePurchaseService {

    private static final Logger logger = LoggerFactory.getLogger(InsurancePurchaseService.class);

    private final InsuranceRepository insuranceRepository;
    private final InsurancePurchaseRepository insurancePurchaseRepository;


    public InsurancePurchaseService(InsuranceRepository insuranceRepository, InsurancePurchaseRepository insurancePurchaseRepository) {
        this.insuranceRepository = insuranceRepository;
        this.insurancePurchaseRepository = insurancePurchaseRepository;
    }


    // Method to purchase an insurance policy.
    public InsurancePurchase purchaseInsurance(Long insuranceId, String buyerName, String email) {
        logger.info("Processing insurance purchase for ID: {}", insuranceId);

        Optional<Insurance> insuranceOpt = insuranceRepository.findById(insuranceId);

        if (insuranceOpt.isEmpty()) {
            logger.warn("Insurance not found with ID: {}", insuranceId);
            throw new RuntimeException("Insurance not found with ID: " + insuranceId);
        }

        Insurance insurance = insuranceOpt.get();

        // Policy document URL
        String policyDocumentUrl = "/api/insurances/download-policy/" + insuranceId;

        InsurancePurchase purchase = new InsurancePurchase(insurance, buyerName, email, policyDocumentUrl);

        InsurancePurchase savedPurchase = insurancePurchaseRepository.save(purchase);

        logger.info("Insurance purchased successfully for Buyer: {} (Email: {}), Policy Document URL: {}",
                buyerName, email, policyDocumentUrl);

        return savedPurchase;
    }

}
