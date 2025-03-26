package com.simplifymoney.insurance_api;

import com.simplifymoney.insurance_api.model.Insurance;
import com.simplifymoney.insurance_api.repository.InsuranceRepository;
import com.simplifymoney.insurance_api.service.InsuranceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.List;

public class InsuranceServiceTest {

    @Mock
    private InsuranceRepository insuranceRepository;

    @InjectMocks
    private InsuranceService insuranceService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllInsurances() {
        List<Insurance> mockInsurances = List.of(
                new Insurance(1L, "Health Guard", "Health", 5000.0, "Covers medical expenses"),
                new Insurance(2L, "Life Secure", "Life", 7000.0, "Life coverage and benefits")
        );

        when(insuranceRepository.findAll()).thenReturn(mockInsurances);

        List<Insurance> result = insuranceService.getAllInsurances();

        assertEquals(2, result.size());
        verify(insuranceRepository, times(1)).findAll();
    }
}
