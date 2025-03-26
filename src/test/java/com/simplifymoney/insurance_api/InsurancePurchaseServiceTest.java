package com.simplifymoney.insurance_api;

import com.simplifymoney.insurance_api.model.Insurance;
import com.simplifymoney.insurance_api.model.InsurancePurchase;
import com.simplifymoney.insurance_api.repository.InsurancePurchaseRepository;
import com.simplifymoney.insurance_api.repository.InsuranceRepository;
import com.simplifymoney.insurance_api.service.InsurancePurchaseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class InsurancePurchaseServiceTest {

    @Mock
    private InsuranceRepository insuranceRepository;

    @Mock
    private InsurancePurchaseRepository insurancePurchaseRepository;

    @InjectMocks
    private InsurancePurchaseService insurancePurchaseService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testPurchaseInsurance_Success() {
        Insurance mockInsurance = new Insurance(1L, "Health Guard", "Health", 5000.0, "Covers medical expenses");
        when(insuranceRepository.findById(1L)).thenReturn(Optional.of(mockInsurance));

        InsurancePurchase purchase = insurancePurchaseService.purchaseInsurance(1L, "Rahul Singh", "rahul@example.com");

        assertNotNull(purchase);
        assertEquals("Rahul Pratap Singh", purchase.getBuyerName());
        assertEquals("rahul@example.com", purchase.getEmail());
        verify(insurancePurchaseRepository, times(1)).save(any(InsurancePurchase.class));
    }
}
