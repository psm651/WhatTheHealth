package com.wthealth.service.activity.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.wthealth.common.Search;
import com.wthealth.domain.Interest;
import com.wthealth.domain.Meeting;
import com.wthealth.domain.Post;
import com.wthealth.domain.Reply;
import com.wthealth.service.activity.ActivityDao;

@Repository("activityDaoImpl")
public class ActivityDaoImpl implements ActivityDao {
	
	///Field
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public ActivityDaoImpl() {
		// TODO Auto-generated constructor stub
		System.out.println(this.getClass());
	}

	@Override
	public List<Post> listMyPost(Search search) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("ActivityMapper.listMyPost", search);
	}

	@Override
	public int getTotalCount(Search search) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("ActivityMapper.getTotalCount", search);
	}

}
