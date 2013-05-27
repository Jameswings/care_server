package com.cd.careserver.action.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class EcgAction extends JsonAction {

	private static final long serialVersionUID = 7639168962676328389L;

	public String restoreEcgNumber(){
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("date", "2013-05-16");
		dataMap.put("number", 5);
		list.add(dataMap);
		
		this.setSuccess();
		reply.setValue(list);
		return JSON;
	}
}
