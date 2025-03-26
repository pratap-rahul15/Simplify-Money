// Controller layer - The layer is responsible for accepting all the request from the user & replying back with the proper user requests.

package com.simplifymoney.insurance_api.controller;

import com.simplifymoney.insurance_api.model.Insurance;
import com.simplifymoney.insurance_api.service.InsuranceService;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/insurances")
public class InsuranceController {

    private final InsuranceService insuranceService;


    public InsuranceController(InsuranceService insuranceService) {
        this.insuranceService = insuranceService;
    }

    // API to fetch all available insurances
    @GetMapping
    public List<Insurance> getAllInsurances() {
        return insuranceService.getAllInsurances();
    }

    // API to download the policy document for a purchased insurance
    @GetMapping("/{id}/download")
    public ResponseEntity<Resource> downloadPolicy(@PathVariable Long id) {
        try {

            // Load the policy document from the static file.
            Path path = Paths.get("src/main/resources/static/policy.pdf");
            Resource resource = new UrlResource(path.toUri());

            // Check if the file exists and is readable
            if (resource.exists() || resource.isReadable()) {
                return ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_PDF)
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"policy.pdf\"")
                        .body(resource);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
