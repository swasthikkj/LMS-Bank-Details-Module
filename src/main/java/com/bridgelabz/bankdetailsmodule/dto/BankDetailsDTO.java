package com.bridgelabz.bankdetailsmodule.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class BankDetailsDTO {
	@Pattern(regexp = "^[a-zA-Z\\s]{2,}$", message = "Bank name is Invalid")
	private String bankName;
	@NotBlank(message = "account number cannot be empty")
	private Long accountNo;
	@NotBlank(message = "IFSC code cannot be empty")
	private String ifscCode;
	@Pattern(regexp = "^[a-zA-Z\\s]{2,}$", message = "Branch is Invalid")
	private String branch;
	@Pattern(regexp = "^[9,8,7,6]{1}[0-9]{9}$", message = "mobile number is invalid")
	private Long linkedMobNo;
	@Pattern(regexp = "^[A-Z]{1}[a-z\\s]{2,}[a-zA-Z]{3,}$", message = "Full name Invalid")
	private String accountHolderName;
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "email is invalid")
	private String email;
	private LocalDateTime creatorDateTime;
	private LocalDateTime updatedDateTime;
}
