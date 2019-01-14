package com.wthealth.service.excom;

import java.util.List;

import com.wthealth.common.Search;
import com.wthealth.domain.Post;

public interface ExComDao {

	public void addExCom(Post post) throws Exception;
	
	public Post getExCom(int postNo) throws Exception;

	public List<Post> listExCom(int postNo) throws Exception;

	public void updateExCom(Post post) throws Exception;

	public void deleteExCom(int postNo) throws Exception;

	public List<Post> listExComRecom(int postNo) throws Exception;

	// �Խ��� Page ó���� ���� ��üRow(totalCount) return
	public int getTotalCount(Search search) throws Exception;
}
