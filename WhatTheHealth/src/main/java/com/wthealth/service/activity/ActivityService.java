package com.wthealth.service.activity;

import java.util.Map;

import com.wthealth.common.Search;
import com.wthealth.domain.Interest;
import com.wthealth.domain.Meeting;
import com.wthealth.domain.Post;
import com.wthealth.domain.Reply;

public interface ActivityService {
	
	public Map<String , Object> listMyPost(Search search) throws Exception ;

}
