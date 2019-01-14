package com.wthealth.service.point.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.wthealth.common.Search;
import com.wthealth.domain.Point;
import com.wthealth.service.point.PointDao;
import com.wthealth.service.point.PointService;

@Service("pointServiceImpl")
public class PointServiceImpl implements PointService {
	
	@Autowired
	@Qualifier("pointDaoImpl")
	private PointDao pointDao;
	public void setPointDao(PointDao pointDao) {
		this.pointDao = pointDao;
	}
	
	///Constructor
	public PointServiceImpl() {
		System.out.println(this.getClass());
	}

	@Override
	public void addPoint(Point point) throws Exception {
		// TODO Auto-generated method stub
		pointDao.addPoint(point);
	}

	@Override
	public Map<String, Object> listPoint(Search search) throws Exception {
		// TODO Auto-generated method stub
		List<Point> list= pointDao.listPoint(search);
		int totalCount = pointDao.getTotalCount(search);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list );
		map.put("totalCount", new Integer(totalCount));
		
		return map;
	}

	@Override
	public void updatePoint(Point point) throws Exception {
		// TODO Auto-generated method stub
		pointDao.updatePoint(point);
		
	}

	

}
