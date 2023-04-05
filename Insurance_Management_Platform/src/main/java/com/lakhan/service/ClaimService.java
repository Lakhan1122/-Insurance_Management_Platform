package com.lakhan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lakhan.Entity.Claim;
import com.lakhan.Entity.InsurancePolicy;
import com.lakhan.exception.BadRequestException;
import com.lakhan.exception.ResourceNotFoundException;
import com.lakhan.repo.ClaimRepository;
import com.lakhan.repo.InsurancePolicyRepository;

@Service
public class ClaimService {

    private final ClaimRepository claimRepository;
    private final InsurancePolicyRepository insurancePolicyRepository;

    public ClaimService(ClaimRepository claimRepository, InsurancePolicyRepository insurancePolicyRepository) {
        this.claimRepository = claimRepository;
        this.insurancePolicyRepository = insurancePolicyRepository;
    }

    public List<Claim> getAllClaims() {
        return claimRepository.findAll();
    }

    public Claim getClaimById(Long id) {
        return claimRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Claim not found with id: " + id));
    }

    public Claim createClaim(Claim claim) throws BadRequestException
    {
    	InsurancePolicy policy = insurancePolicyRepository.findById(claim.getId())
    	.orElseThrow(() -> new ResourceNotFoundException("Policy not found with id: " + claim.getId()));
    	// Make sure the policy is active before creating a claim
    	if (!policy.isActive()) {
    	throw new BadRequestException("Cannot create a claim on an inactive policy.");
    	}
    	// Set the policy on the claim
    	claim.setInsurancePolicy(policy);
    	return claimRepository.save(claim);
    	}
    
    public Claim updateClaim(Long id, Claim updatedClaim) throws BadRequestException {
        Claim claim = claimRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Claim not found with id: " + id));
        InsurancePolicy policy = insurancePolicyRepository.findById(updatedClaim.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Policy not found with id: " + updatedClaim.getId()));
        // Make sure the policy is active before updating the claim
        if (!policy.isActive()) {
            throw new BadRequestException("Cannot update a claim on an inactive policy.");
        }
        // Update the claim with the new information
        claim.setAmount(updatedClaim.getAmount());
        claim.setClaimDate(updatedClaim.getClaimDate());
        claim.setDescription(updatedClaim.getDescription());
        claim.setInsurancePolicy(policy);
        return claimRepository.save(claim);
    }

    public void deleteClaim(Long id) {
        Claim claim = claimRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Claim not found with id: " + id));
        claimRepository.delete(claim);
    }
}


