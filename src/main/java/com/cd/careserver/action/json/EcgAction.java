package com.cd.careserver.action.json;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.cd.careserver.condition.EcgCondition;
import com.cd.careserver.service.EcgService;
import com.cd.careserver.vo.EcgInfo;


public class EcgAction extends JsonAction {

	private static final long serialVersionUID = 7639168962676328389L;

	private String startDate;
	private String endDate;
	
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
	
	public String getEcgList(){
		List<EcgInfo> list = Collections.emptyList();
		if (getSessionDoctor() != null){
			EcgCondition con = new EcgCondition();
			con.setDoctorId(getSessionDoctor().getId());
			con.setStartDate(startDate);
			con.setEndDate(endDate);
			list = ecgService.getEcgInfoByCondition(con);
		}
		reply.setValue(list);
		
		return JSON;
	}
	
	private EcgService ecgService;
	public void setEcgService(EcgService ecgService) {
		this.ecgService = ecgService;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
}
