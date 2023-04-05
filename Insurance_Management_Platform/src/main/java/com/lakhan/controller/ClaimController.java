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

import com.lakhan.Entity.Claim;
import com.lakhan.exception.BadRequestException;
import com.lakhan.service.ClaimService;

@RestController
@RequestMapping("/api/claims")
public class ClaimController {

    private final ClaimService claimService;

    public ClaimController(ClaimService claimService) {
        this.claimService = claimService;
    }

    @GetMapping
    public List<Claim> getAllClaims() {
        return claimService.getAllClaims();
    }

    @GetMapping("/{id}")
    public Claim getClaimById(@PathVariable Long id) {
        return claimService.getClaimById(id);
    }

    @PostMapping
    public Claim createClaim(@RequestBody Claim claim) throws BadRequestException {
        return claimService.createClaim(claim);
    }

    @PutMapping("/{id}")
    public Claim updateClaim(@PathVariable Long id, @RequestBody Claim updatedClaim) throws BadRequestException {
        return claimService.updateClaim(id, updatedClaim);
    }

    @DeleteMapping("/{id}")
    public void deleteClaim(@PathVariable Long id) {
        claimService.deleteClaim(id);
    }
}
