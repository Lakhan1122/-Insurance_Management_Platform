package com.lakhan.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lakhan.Entity.Claim;

public interface ClaimRepository extends JpaRepository<Claim, Long>{

	List<Claim> findAll();

}
