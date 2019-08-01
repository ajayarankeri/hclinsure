package com.hcl.hclinsure.controller;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.hclinsure.dto.CustomerPolicyDto;
import com.hcl.hclinsure.exception.NoOrderFoundException;
import com.hcl.hclinsure.exception.ResourceNotFoundException;
import com.hcl.hclinsure.service.PolicyService;
import com.hcl.hclinsure.serviceimpl.CustomerPolicyServiceImpl;

@RestController
@RequestMapping("/policies")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PolicyController {

	@Autowired
	CustomerPolicyServiceImpl customerServicePolicyImpl;
	
	@RequestMapping(value = "/statement/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> policiesReport(@PathVariable long id) {

        List<CustomerPolicyDto> list = customerServicePolicyImpl.getCustomerPolicyList(id);

        ByteArrayInputStream bis = customerServicePolicyImpl.policyReport(list);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=PoliciesReport.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

	
	@Autowired
	PolicyService policyService;
	
	
	@GetMapping("/policy/{policyId}")
	public ResponseEntity<Object> getPolicyDetails(@PathVariable("policyId") Long policyId) throws ResourceNotFoundException {
	
		return new ResponseEntity<>(policyService.getPolicyDetails(policyId),HttpStatus.OK);
		
	}
	

	@GetMapping("/all")
	public ResponseEntity<Object> policyList() throws ResourceNotFoundException, NoOrderFoundException {
		return new ResponseEntity<>(policyService.policyList(),HttpStatus.OK);	
        }
	
}
