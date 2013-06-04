package com.cd.careserver.service.impl;

import java.util.List;
import java.util.Map;

import com.cd.careserver.dao.EcgDataDao;
import com.cd.careserver.dao.EcgMixedDao;
import com.cd.careserver.service.EcgService;
import com.cd.careserver.vo.EcgInfo;

public class EcgServiceImpl implements EcgService {
	private EcgMixedDao ecgMixedDao;
	private EcgDataDao ecgDataDao;
	
	public List<EcgInfo> getEcgInfoByCondition(String docId){
		return ecgMixedDao.findByDoctorId(docId);
	}
	
	public Map<String, Integer> countUnreadByCondition(String docId){
		return ecgMixedDao.countUnreadNumber(docId);
	}

	public void setEcgMixedDao(EcgMixedDao ecgMixedDao) {
		this.ecgMixedDao = ecgMixedDao;
	}

	public void setEcgDataDao(EcgDataDao ecgDataDao) {
		this.ecgDataDao = ecgDataDao;
	}
}
