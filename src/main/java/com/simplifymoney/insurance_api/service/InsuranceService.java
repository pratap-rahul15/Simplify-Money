// Service layer - which contains the actual business logic.
package com.simplifymoney.insurance_api.service;

import com.simplifymoney.insurance_api.model.Insurance;
import com.simplifymoney.insurance_api.model.InsurancePurchase;
import com.simplifymoney.insurance_api.repository.InsuranceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuranceService {

    private static final Logger logger = LoggerFactory.getLogger(InsuranceService.class);


    private final InsuranceRepository insuranceRepository;

    public InsuranceService(InsuranceRepository insuranceRepository) {
        this.insuranceRepository = insuranceRepository;
    }

    public List<Insurance> getAllInsurances() {
        List<Insurance> insurances = insuranceRepository.findAll();
        logger.info("Fetched insurances: " + insurances.size());
        return insurances;
    }

    public InsurancePurchase purchaseInsurance(Long insuranceId, String buyerName, String email) {
        return null;
    }
}
