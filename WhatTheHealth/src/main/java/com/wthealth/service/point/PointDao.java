package com.wthealth.service.point;

import java.util.List;

import com.wthealth.common.Search;
import com.wthealth.domain.Point;


public interface PointDao {
	
		// INSERT
		public void addPoint(Point point) throws Exception ;

		// SELECT LIST
		public List<Point> listPoint(Search search) throws Exception ;

		// UPDATE
		public void updatePoint(Point point) throws Exception ;
		
		// �Խ��� Page ó���� ���� ��üRow(totalCount)  return
		public int getTotalCount(Search search) throws Exception ;
		
}
