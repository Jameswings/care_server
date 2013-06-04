package com.cd.careserver.action.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.cd.careserver.service.EcgService;


public class EcgAction extends JsonAction {

	private static final long serialVersionUID = 7639168962676328389L;

	private EcgService ecgService;
	
	public String restoreEcgNumber(){
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		if (getSessionDoctor() != null){
			Map<String, Integer> map = ecgService.countUnreadByCondition(getSessionDoctor().getId());
			
			Map<String, Object> data;
			for (Entry<String, Integer> entry: map.entrySet()){
				data = new HashMap<String, Object>();
				data.put("date", entry.getKey());
				data.put("number", entry.getValue());
				list.add(data);
			}
		}
		reply.setValue(list);
		
		this.setSuccess();
		
		return JSON;
	}

	public void setEcgService(EcgService ecgService) {
		this.ecgService = ecgService;
	}
}
