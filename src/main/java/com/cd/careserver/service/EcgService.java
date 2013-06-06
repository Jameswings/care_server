package com.cd.careserver.service;

import java.util.List;
import java.util.Map;

import com.cd.careserver.condition.EcgCondition;
import com.cd.careserver.vo.EcgInfo;

public interface EcgService {

	List<EcgInfo> getEcgInfoByCondition(EcgCondition con);

	Map<String, Integer> countUnreadByCondition(String docId);

}
