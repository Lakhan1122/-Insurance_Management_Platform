package com.lakhan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lakhan.Entity.Client;
import com.lakhan.Entity.InsurancePolicy;
import com.lakhan.exception.ResourceNotFoundException;
import com.lakhan.repo.ClientRepository;
import com.lakhan.repo.InsurancePolicyRepository;

@Service
public class InsurancePolicyService {

    private final InsurancePolicyRepository insurancePolicyRepository;
    private final ClientRepository clientRepository;

    public InsurancePolicyService(InsurancePolicyRepository insurancePolicyRepository, ClientRepository clientRepository) {
        this.insurancePolicyRepository = insurancePolicyRepository;
        this.clientRepository = clientRepository;
    }

    public List<InsurancePolicy> getAllInsurancePolicies() {
        return insurancePolicyRepository.findAll();
    }

    public InsurancePolicy getInsurancePolicyById(Long id) {
        return insurancePolicyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Insurance policy not found with id: " + id));
    }

    public InsurancePolicy createInsurancePolicy(InsurancePolicy insurancePolicy) {
        Client client = clientRepository.findById(insurancePolicy.getClient().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Client not found with id: " + insurancePolicy.getClient().getId()));
        insurancePolicy.setClient(client);
        return insurancePolicyRepository.save(insurancePolicy);
    }

    public InsurancePolicy updateInsurancePolicy(Long id, InsurancePolicy insurancePolicyDetails) {
        InsurancePolicy insurancePolicy = getInsurancePolicyById(id);
        Client client = clientRepository.findById(insurancePolicyDetails.getClient().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Client not found with id: " + insurancePolicyDetails.getClient().getId()));
        insurancePolicy.setClient(client);
        insurancePolicy.setPolicyNumber(insurancePolicyDetails.getPolicyNumber());
        insurancePolicy.setPolicyType(insurancePolicyDetails.getPolicyType());
        insurancePolicy.setCoverageAmount(insurancePolicyDetails.getCoverageAmount());
        insurancePolicy.setPremium(insurancePolicyDetails.getPremium());
        insurancePolicy.setStartDate(insurancePolicyDetails.getStartDate());
        insurancePolicy.setEndDate(insurancePolicyDetails.getEndDate());
        return insurancePolicyRepository.save(insurancePolicy);
    }

    public void deleteInsurancePolicy(Long id) {
        InsurancePolicy insurancePolicy = getInsurancePolicyById(id);
        insurancePolicyRepository.delete(insurancePolicy);
    }

}

