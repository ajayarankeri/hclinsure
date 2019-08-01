package com.hcl.hclinsure.serviceimpl;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hcl.hclinsure.dto.PoliciesOptDto;
import com.hcl.hclinsure.dto.ReportDto;
import com.hcl.hclinsure.dto.ResponseDto;
import com.hcl.hclinsure.entity.Customer;
import com.hcl.hclinsure.entity.CustomerPolicy;
import com.hcl.hclinsure.entity.Policy;
import com.hcl.hclinsure.exception.NotCorrectInformationException;
import com.hcl.hclinsure.exception.ResourceNotFoundException;
import com.hcl.hclinsure.repository.CustomerPolicyRepository;
import com.hcl.hclinsure.repository.CustomerRepository;
import com.hcl.hclinsure.repository.PolicyRepository;
import com.hcl.hclinsure.service.PolicyService;

@Component
public class PolicyServiceImpl implements PolicyService{

	
	@Autowired
	PolicyRepository policyRepository;

	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	CustomerPolicyRepository customerPolicyRepository;
	
	
	
	public String savePolicies(PoliciesOptDto policiesOptDto) throws ResourceNotFoundException, NotCorrectInformationException {
		
		Policy policy=policyRepository.findById(policiesOptDto.getPolicyId()).orElseThrow(()-> new ResourceNotFoundException("Policies not found"));
		Customer customer=customerRepository.findById(policiesOptDto.getUserId()).orElseThrow(()-> new ResourceNotFoundException("User not found"));
		boolean boll=Period.between(customer.getCustomerDateOfBirth(),LocalDate.now()).getYears()< policy.getPolicyFromAge() ?true:false;
		boolean boll1=(Period.between(customer.getCustomerDateOfBirth(),LocalDate.now()).getYears()>policy.getPolicyFromAge());
		System.out.println("policy record"+policy.getPolicyFromAge()+policy.getPolicyToAge()+boll+boll1);
		if((Period.between(customer.getCustomerDateOfBirth(),LocalDate.now()).getYears()<policy.getPolicyToAge()) && (Period.between(customer.getCustomerDateOfBirth(),LocalDate.now()).getYears()>policy.getPolicyFromAge()) )
		{
			if(null!=customerPolicyRepository.findByCustomerIdAndPolicyId(customer, policy)) {
				throw new NotCorrectInformationException("you allready opt this policy");
			}
			
		
			if(!policiesOptDto.getTermAndConditions().equalsIgnoreCase("yes")) {
				throw new NotCorrectInformationException("please agree term and conditions");
			}
			
			
			if(policiesOptDto.getSumAssured()<=policy.getPolicyBaseAmount())
			{
				throw new NotCorrectInformationException("please enter sum assured amount greater than "+policy.getPolicyBaseAmount());
			}
			CustomerPolicy customerPolicy=new CustomerPolicy();
			customerPolicy.setCustomerId(customer);
	        customerPolicy.setPolicyId(policy); 
	        customerPolicy.setPolicyStartDate(LocalDate.now());
	        customerPolicy.setPolicyEndDate(LocalDate.now().plusMonths(policy.getPolicyPeriod()));
	        customerPolicy.setPolicyFrequency("M");
	        customerPolicy.setTermsAndConditionStatus(1);
	 	    
	        long premiumAmount=policiesOptDto.getSumAssured()/(policy.getPolicyPeriod()/12);
	        customerPolicy.setPolicyPremiumAmount(Double.valueOf(premiumAmount));
	        customerPolicy.setPolicyTotalAmount(Double.valueOf(0));
	        customerPolicy.setPolicyMaturityAmount(Double.valueOf(policiesOptDto.getSumAssured()));
	        customerPolicyRepository.save(customerPolicy);
			return "Policy opt sucessfully";
	
		}
		else {
			throw new NotCorrectInformationException("your age is not sutable for this policy");
		}
		
	}
	
	@Override
	public ResponseDto getPolicyDetails(Long policyId) throws ResourceNotFoundException {
		Policy policyDetails=policyRepository.findById(policyId).orElseThrow(()->new ResourceNotFoundException("Policy Not Available"));
		return new ResponseDto("sucess", 200, policyDetails);
	}

	@Override
	public ResponseDto policyList() throws ResourceNotFoundException {
	 List<Policy> policyList =policyRepository.findAll(); 
	 if(policyList.isEmpty()) {
	    	throw new ResourceNotFoundException("No policy list result found");
	    }		
		return  new ResponseDto("sucess", 200 , policyList);
	}
	
	@Override
	public List<ReportDto> analysisReport(String type) throws ResourceNotFoundException {
	
		
		List<List<?>> analysisReport = null;
		ReportDto reportDto = null;
		List<ReportDto> reportDtos = new ArrayList<>();
		if(type.equals("weekly"))
		analysisReport = policyRepository.findAnalysisReportWeekly();
		else if (type.equals("monthly")) {
		analysisReport = policyRepository.findAnalysisReportMonthly();	
		}else {
		analysisReport = policyRepository.findAnalysisReport();
		}

		for (List<?> objs : analysisReport) {
			reportDto = new ReportDto();
			reportDto.setPolicyId(Integer.parseInt(String.valueOf(objs.get(0))));
			reportDto.setPolicyName(String.valueOf(objs.get(1)));
			reportDto.setPolicyCount(Integer.parseInt(String.valueOf(objs.get(2))));
			reportDto.setPolicyPercentage(Double.parseDouble(String.valueOf(objs.get(3))));
			reportDtos.add(reportDto);
		}  
		
		return reportDtos;
	}
	
}
