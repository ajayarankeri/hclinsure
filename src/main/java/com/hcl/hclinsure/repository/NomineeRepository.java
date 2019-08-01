package com.hcl.hclinsure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.hclinsure.entity.Nominee;

@Repository
public interface NomineeRepository extends JpaRepository<Nominee, Long>{
	
	

}
