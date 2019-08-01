package com.hcl.hclinsure.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.hclinsure.entity.Policy;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long>{

	//@Query("SELECT new com.hcl.hclinsure.dto.ProductsDto(p.productId.productId,MAX(round(p.productVersion,2)),p.productName,p.productDescription)   FROM ProductVersion p GROUP BY p.productId.productId")
	/*
	 * @Query("SELECT new com.hcl.hclinsure.dto.ReportDto(
	 * p.policyId.policyId,IFNULL(count,0) as count ,IFNULL(percentage,0) as
	 * percentage from ( SELECT cp.policyId.policyId,count(cp.policyId.policyId) as
	 * count,IFNULL((count(cp.policyId.policyId)/t.total)*100,0) as percentage FROM
	 * CustomerPolicy cp cross join (select count(*) as total from CustomerPolicy ct
	 * WHERE ct.policyStartDate >= DATE(NOW()) - INTERVAL 7 DAY ) t WHERE
	 * cp.policyStartDate >= DATE(NOW()) - INTERVAL 7 DAY group by
	 * cp.policyId.policyId ) as a right join Policy p on p.policyId=a.policyId")
	 */
	
	
	
	
	@Query(value="select p.policy_id,IFNULL(count,0) as count ,IFNULL(percentage,0) as percentage from (\r\n" + 
			"SELECT cp.policy_id,count(cp.policy_id) as count,IFNULL((count(cp.policy_id)/t.total)*100,0) as percentage FROM hclinsure.customer_policy  cp\r\n" + 
			"cross join (select count(*) as total from hclinsure.customer_policy ct\r\n" + 
			"WHERE ct.policy_start_date >= DATE(NOW()) - INTERVAL 7 DAY\r\n" + 
			") t\r\n" + 
			"WHERE cp.policy_start_date >= DATE(NOW()) - INTERVAL 7 DAY\r\n" + 
			"group by cp.policy_id ) as a\r\n" + 
			"right join\r\n" + 
			"hclinsure.policy p\r\n" + 
			"on p.policy_id=a.policy_id\r\n" + 
			"",nativeQuery = true)
	public List<List<?>> findAnalysisReport();
	
	@Query(value="select p.policy_id,IFNULL(count,0) as count ,IFNULL(percentage,0) as percentage from (\r\n" + 
			"SELECT cp.policy_id,count(cp.policy_id) as count,IFNULL((count(cp.policy_id)/t.total)*100,0) as percentage FROM hclinsure.customer_policy  cp\r\n" + 
			"cross join (select count(*) as total from hclinsure.customer_policy ct\r\n" + 
			"WHERE YEAR(ct.policy_start_date) = YEAR(CURRENT_DATE - INTERVAL 1 MONTH)\r\n" + 
			"AND MONTH(ct.policy_start_date) = MONTH(CURRENT_DATE - INTERVAL 1 MONTH)\r\n" + 
			") t\r\n" + 
			"WHERE YEAR(cp.policy_start_date) = YEAR(CURRENT_DATE - INTERVAL 1 MONTH)\r\n" + 
			"AND MONTH(cp.policy_start_date) = MONTH(CURRENT_DATE - INTERVAL 1 MONTH)\r\n" + 
			"group by cp.policy_id ) as a\r\n" + 
			"right join\r\n" + 
			"hclinsure.policy p\r\n" + 
			"on p.policy_id=a.policy_id\r\n" + 
			"",nativeQuery = true)
	public List<List<?>> findAnalysisReportMonthly();
}
