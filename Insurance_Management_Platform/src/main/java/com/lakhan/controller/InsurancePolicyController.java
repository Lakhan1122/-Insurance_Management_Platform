package com.lakhan.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lakhan.Entity.InsurancePolicy;
import com.lakhan.service.InsurancePolicyService;

@RestController
@RequestMapping("/api/policies")
public class InsurancePolicyController {

    private final InsurancePolicyService insurancePolicyService;

    public InsurancePolicyController(InsurancePolicyService insurancePolicyService) {
        this.insurancePolicyService = insurancePolicyService;
    }

    @GetMapping
    public List<InsurancePolicy> getAllInsurancePolicies() {
        return insurancePolicyService.getAllInsurancePolicies();
    }

    @GetMapping("/{id}")
    public InsurancePolicy getInsurancePolicyById(@PathVariable Long id) {
        return insurancePolicyService.getInsurancePolicyById(id);
    }

    @PostMapping
    public InsurancePolicy createInsurancePolicy(@RequestBody InsurancePolicy insurancePolicy) {
        return insurancePolicyService.createInsurancePolicy(insurancePolicy);
    }

    @PutMapping("/{id}")
    public InsurancePolicy updateInsurancePolicy(@PathVariable Long id, @RequestBody InsurancePolicy updatedInsurancePolicy) {
        return insurancePolicyService.updateInsurancePolicy(id, updatedInsurancePolicy);
    }

    @DeleteMapping("/{id}")
    public void deleteInsurancePolicy(@PathVariable Long id) {
        insurancePolicyService.deleteInsurancePolicy(id);
    }
}
