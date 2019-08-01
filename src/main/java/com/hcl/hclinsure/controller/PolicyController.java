package com.hcl.hclinsure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.hclinsure.dto.PoliciesOptDto;
import com.hcl.hclinsure.exception.NotCorrectInformationException;
import com.hcl.hclinsure.exception.ResourceNotFoundException;
import com.hcl.hclinsure.service.PolicyService;

@RestController
@RequestMapping("/policies")
public class PolicyController {

	@Autowired
	PolicyService policyService;
	
	@PostMapping("/policy/select")
	public ResponseEntity<Object> optPolicies(@RequestBody PoliciesOptDto policiesOptDto) throws ResourceNotFoundException, NotCorrectInformationException
	{
		return new ResponseEntity<>(policyService.savePolicies(policiesOptDto),HttpStatus.OK);
	}
	
	
}
