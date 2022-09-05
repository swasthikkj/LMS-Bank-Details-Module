package com.bridgelabz.bankdetailsmodule.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.bridgelabz.bankdetailsmodule.dto.BankDetailsDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bank_details")
@Data
@NoArgsConstructor
public class BankDetailsModel {
	@Id
	@GenericGenerator(name = "bank_details", strategy = "increment")
	@GeneratedValue(generator = "bank_details")
	private Long id;
	private String bankName; 
	private Long accountNo;
	private String ifscCode;
	private String branch;
	private Long linkedMobNo;
	private String accountHolderName;
	private String email;
//	@OneToOne
//	private AdminModel creatorUser;
//	@OneToOne
//	private AdminModel updatedUser;
	private LocalDateTime creatorDateTime;
	private LocalDateTime updatedDateTime;
	
	public BankDetailsModel(BankDetailsDTO bankDetailsDTO) {
		this.bankName = bankDetailsDTO.getBankName();
		this.accountNo = bankDetailsDTO.getAccountNo();
		this.ifscCode = bankDetailsDTO.getIfscCode();
		this.branch = bankDetailsDTO.getBranch();
		this.linkedMobNo = bankDetailsDTO.getLinkedMobNo();
		this.accountHolderName = bankDetailsDTO.getAccountHolderName();
		this.email = bankDetailsDTO.getEmail();
		this.creatorDateTime = bankDetailsDTO.getCreatorDateTime().now();
		this.updatedDateTime = bankDetailsDTO.getUpdatedDateTime().now();
	}
}
