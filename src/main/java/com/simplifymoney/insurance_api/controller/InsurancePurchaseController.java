package com.simplifymoney.insurance_api.controller;

import com.simplifymoney.insurance_api.model.InsurancePurchase;
import com.simplifymoney.insurance_api.service.InsuranceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/insurances")
public class InsurancePurchaseController {

    private final InsuranceService insuranceService;


    public InsurancePurchaseController(InsuranceService insuranceService) {
        this.insuranceService = insuranceService;
    }


    // POST MAPPING (To purchase a new insurance).
    @PostMapping("/{insuranceId}/purchase")
    public ResponseEntity<?> purchaseInsurance(
            @PathVariable Long insuranceId,
            @RequestBody Map<String, String> request
    ) {
        String buyerName = request.get("buyerName");
        String email = request.get("email");

        // Check if request body contains required fields
        if (buyerName == null || email == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", "Missing required fields: buyerName and email"));
        }

        InsurancePurchase purchase = insuranceService.purchaseInsurance(insuranceId, buyerName, email);

        if (purchase != null) {
            return ResponseEntity.ok(purchase);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "Insurance not found for ID: " + insuranceId));
        }
    }
}
