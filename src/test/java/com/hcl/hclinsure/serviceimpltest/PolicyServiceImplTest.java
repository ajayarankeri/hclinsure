package com.hcl.hclinsure.serviceimpltest;

import static org.junit.Assert.assertNotNull;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hcl.hclinsure.entity.Policy;
import com.hcl.hclinsure.exception.ResourceNotFoundException;
import com.hcl.hclinsure.repository.PolicyRepository;
import com.hcl.hclinsure.serviceimpl.PolicyServiceImpl;


@RunWith(SpringJUnit4ClassRunner.class)
public class PolicyServiceImplTest {

	@InjectMocks
	PolicyServiceImpl policyServiceImpl;
	
	@Mock
	PolicyRepository policyRepository;
	
	Policy policy;
	Policy policyFailure;
	
	@Before
	public void setMockData() {
		
		policy=new Policy();
		policyFailure=new Policy();
		
		policy.setPolicyId(1L);
		policy.setPolicyBaseAmount(200000D);
		policy.setPolicyFromAge(18);
		policy.setPolicyToAge(50);
		policy.setPolicyName("Jeevn");
		policy.setPolicyOffer("NA");
		policy.setPolicyPeriod(48);
		policy.setTermsAndCondition("Details - Aggree T&C");
		
		
	}
	
	
	@Test
	public void getPolicyDetailsTest() throws ResourceNotFoundException {
		Mockito.when(policyRepository.findById(1L)).thenReturn(Optional.of(policy));
		assertNotNull(policyServiceImpl.getPolicyDetails(1L));
		
	}
	
	
	  @Test 
	  public void getPolicyDetailsFailureTest() throws ResourceNotFoundException {
		  Mockito.when(policyRepository.findById(2L)).thenReturn(Optional.of(policy)); 
		  assertNotNull(policyServiceImpl.getPolicyDetails(2L)); 
	  }
	 
	
	
	
}
