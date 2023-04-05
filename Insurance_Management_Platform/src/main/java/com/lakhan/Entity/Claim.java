package com.lakhan.Entity;

import java.sql.ClientInfoStatus;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "claims")
public class Claim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String claimNumber;

    private String description;

    private LocalDate claimDate;

    private ClientInfoStatus claimStatus;

    @ManyToOne
    private InsurancePolicy insurancePolicy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClaimNumber() {
		return claimNumber;
	}

	public void setClaimNumber(String claimNumber) {
		this.claimNumber = claimNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getClaimDate() {
		return claimDate;
	}

	public void setClaimDate(LocalDate claimDate) {
		this.claimDate = claimDate;
	}

	public ClientInfoStatus getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(ClientInfoStatus claimStatus) {
		this.claimStatus = claimStatus;
	}

	public InsurancePolicy getInsurancePolicy() {
		return insurancePolicy;
	}

	public void setInsurancePolicy(InsurancePolicy insurancePolicy) {
		this.insurancePolicy = insurancePolicy;
	}

	public Claim(Long id, String claimNumber, String description, LocalDate claimDate, ClientInfoStatus claimStatus,
			InsurancePolicy insurancePolicy) {
		super();
		this.id = id;
		this.claimNumber = claimNumber;
		this.description = description;
		this.claimDate = claimDate;
		this.claimStatus = claimStatus;
		this.insurancePolicy = insurancePolicy;
	}

	public Claim() {
		
	}

	public Object getAmount() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setAmount(Object amount) {
		// TODO Auto-generated method stub
		
	}

    // constructors, getters, and setters
    
    
}


