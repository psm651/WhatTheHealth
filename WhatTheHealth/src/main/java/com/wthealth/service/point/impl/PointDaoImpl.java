package com.wthealth.service.point.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.wthealth.common.Search;
import com.wthealth.domain.Point;
import com.wthealth.service.point.PointDao;

@Repository("pointDaoImpl")
public class PointDaoImpl implements PointDao {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public PointDaoImpl() {
		System.out.println(this.getClass());
	}

	@Override
	public void addPoint(Point point) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert("PointMapper.addPoint", point);
	}

	@Override
	public List<Point> listPoint(Search search) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("PointMapper.listPoint", search);
	}

	@Override
	public void updatePoint(Point point) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("PointMapper.updatePoint", point);
	}

	@Override
	public int getTotalCount(Search search) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("PointMapper.getTotalCount", search);
	}

}
