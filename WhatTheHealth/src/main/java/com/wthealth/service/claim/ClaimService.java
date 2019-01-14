package com.wthealth.service.claim;

import java.util.Map;

import com.wthealth.common.Search;
import com.wthealth.domain.Claim;

public interface ClaimService {

	public Map<String, Object> listClaim(Search search) throws Exception;
	
	public int updateClaim(Claim claim) throws Exception;

	public int addClaim(Claim claim) throws Exception; 
	
	public Claim getClaim(int claimNo) throws Exception; 
}
