package com.hcl.hclinsure.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.hclinsure.dto.CustomerPolicyDto;
import com.hcl.hclinsure.dto.PoliciesOptDto;
import com.hcl.hclinsure.exception.NotCorrectInformationException;
import com.hcl.hclinsure.exception.ResourceNotFoundException;
import com.hcl.hclinsure.service.CustomerPolicyService;
import com.hcl.hclinsure.service.PolicyService;

@RestController
@RequestMapping("/policies")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PolicyController {

	private static final String FILE_PATH = "c:\\mypdf.pdf";
	@Autowired
	PolicyService policyService;
	
	@Autowired
	CustomerPolicyService customerServicePolicyImpl;
	

	@PostMapping("/policy/select")
	public ResponseEntity<Object> optPolicies(@RequestBody PoliciesOptDto policiesOptDto) throws ResourceNotFoundException, NotCorrectInformationException
	{
		return new ResponseEntity<>(policyService.savePolicies(policiesOptDto),HttpStatus.OK);
	}
	

	@GetMapping(value = "/statement/{id}", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> policiesReport(@PathVariable long id) {

        List<CustomerPolicyDto> list = customerServicePolicyImpl.getCustomerPolicyList(id);

        ByteArrayInputStream bis = customerServicePolicyImpl.policyReport(list);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=\"userreport.pdf\"");

        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
        		.body(new InputStreamResource(bis));
          
    }

	
	@GetMapping("/policy/{policyId}")
	public ResponseEntity<Object> getPolicyDetails(@PathVariable("policyId") Long policyId) throws ResourceNotFoundException {
	
		return new ResponseEntity<>(policyService.getPolicyDetails(policyId),HttpStatus.OK);
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<Object> policyList() throws ResourceNotFoundException {
		return new ResponseEntity<>(policyService.policyList(),HttpStatus.OK);	
        }

	@GetMapping("/analysis")
	public ResponseEntity<Object> analysis(@RequestParam(defaultValue = "All") String type) throws ResourceNotFoundException {
		return new ResponseEntity<>(policyService.analysisReport(type),HttpStatus.OK);
		
	}
	
}
