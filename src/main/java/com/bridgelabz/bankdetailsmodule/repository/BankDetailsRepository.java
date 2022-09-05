package com.bridgelabz.bankdetailsmodule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.bankdetailsmodule.model.BankDetailsModel;

@Repository
public interface BankDetailsRepository extends JpaRepository<BankDetailsModel, Long>{
	
}
