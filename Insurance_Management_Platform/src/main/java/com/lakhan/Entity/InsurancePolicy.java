package com.lakhan.Entity;


import java.time.LocalDate;
import org.hibernate.type.AnyType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "policies")
public class InsurancePolicy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String policyNumber;

    private AnyType policyType;

    private Double coverageAmount;

    private Double premium;

    private LocalDate startDate;

    private LocalDate endDate;

    @ManyToOne
    private Client client;

	public InsurancePolicy(Long id, String policyNumber, AnyType policyType, Double coverageAmount, Double premium,
			LocalDate startDate, LocalDate endDate, Client client) {
		super();
		this.id = id;
		this.policyNumber = policyNumber;
		this.policyType = policyType;
		this.coverageAmount = coverageAmount;
		this.premium = premium;
		this.startDate = startDate;
		this.endDate = endDate;
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public AnyType getPolicyType() {
		return policyType;
	}

	public void setPolicyType(AnyType policyType) {
		this.policyType = policyType;
	}

	public Double getCoverageAmount() {
		return coverageAmount;
	}

	public void setCoverageAmount(Double coverageAmount) {
		this.coverageAmount = coverageAmount;
	}

	public Double getPremium() {
		return premium;
	}

	public void setPremium(Double premium) {
		this.premium = premium;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public InsurancePolicy() {
		
	}

	public boolean isActive() {
		// TODO Auto-generated method stub
		return false;
	}

    // constructors, getters, and setters
    
    
}

