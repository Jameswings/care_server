package com.cd.careserver.dao;

import java.util.List;
import java.util.Map;

import com.cd.careserver.vo.EcgInfo;

public interface EcgMixedDao {

	List<EcgInfo> findByDoctorId(String docId);

	Map<String, Integer> countUnreadNumber(String docId);

}
