package com.simplifymoney.insurance_api.config;


import com.simplifymoney.insurance_api.model.Insurance;
import com.simplifymoney.insurance_api.repository.InsuranceRepository;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataSeeder {

    private static final Logger logger = LoggerFactory.getLogger(DataSeeder.class);

    private final InsuranceRepository insuranceRepository;

    public DataSeeder(InsuranceRepository insuranceRepository) {
        this.insuranceRepository = insuranceRepository;
    }

    @PostConstruct
    public void init() {
        try {
            long count = insuranceRepository.count();
            logger.info("Existing insurance count: " + count);

            if (count == 0) {
                List<Insurance> insurances = List.of(
                        new Insurance("Health Guard", "Health", 5000.0, "Covers hospitalization and medical expenses for your health."),
                        new Insurance("Life Secure", "Life", 7000.0, "Provides life coverage and maturity benefits."),
                        new Insurance("Car Shield", "Vehicle", 3000.0, "Covers accidental damage and theft.")
                );
                insuranceRepository.saveAll(insurances);
                logger.info("Sample insurance data inserted successfully.");
            } else {
                logger.info("Skipping data seeding as insurances already exist.");
            }

        } catch (Exception e) {
            logger.error("Error inserting seed data: ", e);
        }
    }



}
