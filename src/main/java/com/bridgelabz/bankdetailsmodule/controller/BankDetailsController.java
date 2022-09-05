package com.bridgelabz.bankdetailsmodule.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.bankdetailsmodule.dto.BankDetailsDTO;
import com.bridgelabz.bankdetailsmodule.model.BankDetailsModel;
//import com.bridgelabz.bankdetailsmodule.model.CandidateModel;
import com.bridgelabz.bankdetailsmodule.service.IBankDetailsService;
import com.bridgelabz.bankdetailsmodule.util.Response;
/**
 * Purpose:create bank details controller
 * @version 4.15.1.RELEASE
 * @author Swasthik KJ
 */
@RestController
@RequestMapping("/bankdetailsmodule")
public class BankDetailsController {
	@Autowired
	IBankDetailsService bankDetailsService;
	/**
	 * Purpose:add bank account 
	 * @Param token and admin id
	 */
	@PostMapping("/addBankAccount")
	public ResponseEntity<Response> addBankDetails(@Valid @RequestBody BankDetailsDTO bankDetailsDTO, @RequestHeader String token) {
		BankDetailsModel bankDetailsModel = bankDetailsService.addBankDetails(bankDetailsDTO, token);
		Response response = new Response(200, "bank account added successfully", bankDetailsModel);
		return new ResponseEntity<>(response, HttpStatus.OK);		
	}
	/**
	 * Purpose:update bank account 
	 * @Param token and id
	 */
	@PutMapping("updateBankDetails/{id}")
	public ResponseEntity<Response> updateBankDetails(@Valid @RequestBody BankDetailsDTO bankDetailsDTO, @PathVariable Long id, @RequestHeader String token) {
		BankDetailsModel bankDetailsModel = bankDetailsService.updateBankDetails(bankDetailsDTO, id, token);
		Response response = new Response(200, "bank account updated successfully", bankDetailsModel);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	/**
	 * Purpose:fetch bank account by id 
	 * @Param token and id
	 */
	@GetMapping("/getBankDetails/{id}")
    public ResponseEntity<Response> getBankDetailsById(@PathVariable Long id, @RequestHeader String token) {
		Optional<BankDetailsModel> bankDetailsModel = bankDetailsService.getBankDetailsById(id, token);
		Response response = new Response(200, "bank account fetched successfully", bankDetailsModel);
		return new ResponseEntity<>(response, HttpStatus.OK);
    }
	/**
	 * Purpose:delete bank account 
	 * @Param token and id
	 */
	@DeleteMapping("/deletebankDetails/{id}")
	public ResponseEntity<Response> deleteBankDetails(@PathVariable Long id, @RequestHeader String token) {
		BankDetailsModel bankDetailsModel = bankDetailsService.deleteBankDetails(id, token);
		Response response = new Response(200, "bank account deleted successfully", bankDetailsModel);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
