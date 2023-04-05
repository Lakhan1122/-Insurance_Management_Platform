package com.lakhan.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lakhan.Entity.InsurancePolicy;

public interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy, Long>{

}
