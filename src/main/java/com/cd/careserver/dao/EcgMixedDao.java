package com.cd.careserver.dao;

import java.util.List;
import java.util.Map;

import com.cd.careserver.condition.EcgCondition;
import com.cd.careserver.vo.EcgInfo;

public interface EcgMixedDao {

	List<EcgInfo> findByCondition(EcgCondition con);

	Map<String, Integer> countUnreadNumber(String docId);

}
