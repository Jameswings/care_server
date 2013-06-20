package com.cd.careserver.service;

import java.util.List;
import java.util.Map;

import com.cd.careserver.condition.EcgCondition;
import com.cd.careserver.po.EcgData;
import com.cd.careserver.vo.DataModel;
import com.cd.careserver.vo.EcgInfo;

public interface EcgService {

	boolean readEcg(String docId, String ecgId);
	
	List<EcgInfo> getEcgInfoByCondition(EcgCondition con);

	Map<String, Integer> countUnreadByCondition(String docId);

	DataModel loadEcgData(String ecgId);
	
	String addEcg(EcgData ecg);
}
