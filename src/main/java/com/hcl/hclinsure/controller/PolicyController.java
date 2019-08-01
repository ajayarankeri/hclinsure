package com.hcl.hclinsure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.hclinsure.exception.ResourceNotFoundException;
import com.hcl.hclinsure.service.PolicyService;

@RestController
@RequestMapping("/policies")
public class PolicyController {
	
	@Autowired
	PolicyService policyService;
	
	
	@GetMapping("/policy/{policyId}")
	public ResponseEntity<Object> getPolicyDetails(@PathVariable("policyId") Long policyId) throws ResourceNotFoundException {
	
		return new ResponseEntity<>(policyService.getPolicyDetails(policyId),HttpStatus.OK);
		
	}
	
	
	
}
