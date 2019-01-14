package com.wthealth.service.point;

import java.util.Map;

import com.wthealth.common.Search;
import com.wthealth.domain.Point;

public interface PointService {
	
	public void addPoint(Point point) throws Exception;

	public Map<String,Object> listPoint(Search search) throws Exception;

	public void updatePoint(Point point) throws Exception;

}
