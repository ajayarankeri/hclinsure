package com.hcl.hclinsure.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.hclinsure.dto.CustomerPolicyDto;

@Service
public interface CustomerPolicyService {
	public  ByteArrayInputStream policyReport(List<CustomerPolicyDto> cutomerPolicy);
	public  List<CustomerPolicyDto> getCustomerPolicyList(long id);
}
