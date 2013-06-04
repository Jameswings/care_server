package com.cd.careserver.action.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cd.careserver.service.EcgService;
import com.cd.careserver.vo.EcgInfo;


public class EcgAction extends JsonAction {

	private static final long serialVersionUID = 7639168962676328389L;

	private EcgService ecgService;
	
	public String restoreEcgNumber(){
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("date", "2013-05-16");
		dataMap.put("number", 5);
		list.add(dataMap);
		
		if (getSessionDoctor() != null){
//			List<EcgInfo> eiList = ecgService.getEcgInfoByCondition(getSessionDoctor().getId());
//			for (ei)
			reply.setValue(ecgService.countUnreadByCondition(getSessionDoctor().getId()));
		}
		
		this.setSuccess();
		
		return JSON;
	}

	public void setEcgService(EcgService ecgService) {
		this.ecgService = ecgService;
	}
}
