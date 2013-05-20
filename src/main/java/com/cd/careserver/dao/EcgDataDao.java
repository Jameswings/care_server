package com.cd.careserver.dao;

import java.util.List;

import com.cd.careserver.po.EcgData;

public interface EcgDataDao {

	EcgData findById(String ecgDataId);

	String update(EcgData ecgData);

	String delete(String ecgDataId);

	String insert(EcgData ecgData);

	List<EcgData> findAll();

}
