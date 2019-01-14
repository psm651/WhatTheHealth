package com.wthealth.service.refund;

import java.util.List;

import com.wthealth.common.Search;
import com.wthealth.domain.Refund;

public interface RefundDao {
	
	public void addRefund(Refund refund) throws Exception;

	public List<Refund> listRefund(int refundNo) throws Exception;

	public Refund getRefund(int refundNo) throws Exception;

	public void updateRefund(Refund refund) throws Exception;
	
	public List<Refund> listRefundAdmin(int refundNo) throws Exception;
	
	// �Խ��� Page ó���� ���� ��üRow(totalCount) return
	public int getTotalCount(Search search) throws Exception;
}
