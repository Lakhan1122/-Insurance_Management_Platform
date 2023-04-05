package com.lakhan.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lakhan.Entity.Client;



public interface ClientRepository extends JpaRepository<Client, Long> {
	
	
	
}

