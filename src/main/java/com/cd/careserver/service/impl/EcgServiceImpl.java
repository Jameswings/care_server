package com.cd.careserver.service.impl;

import java.util.List;
import java.util.Map;

import com.cd.careserver.condition.EcgCondition;
import com.cd.careserver.dao.DoctorEcgDao;
import com.cd.careserver.dao.EcgDataDao;
import com.cd.careserver.dao.EcgMixedDao;
import com.cd.careserver.helper.DataDecoder;
import com.cd.careserver.po.DoctorEcg;
import com.cd.careserver.po.EcgData;
import com.cd.careserver.service.EcgService;
import com.cd.careserver.service.FileTransferService;
import com.cd.careserver.vo.DataModel;
import com.cd.careserver.vo.EcgInfo;

public class EcgServiceImpl implements EcgService {
	private EcgMixedDao ecgMixedDao;
	private EcgDataDao ecgDataDao;
	private DoctorEcgDao doctorEcgDao;

	private FileTransferService fileTransferService;

	public List<EcgInfo> getEcgInfoByCondition(EcgCondition con) {
		return ecgMixedDao.findByCondition(con);
	}

	public Map<String, Integer> countUnreadByCondition(String docId) {
		return ecgMixedDao.countUnreadNumber(docId);
	}

	@Override
	public boolean readEcg(String docId, String ecgId) {
		EcgData ecg = ecgDataDao.findById(ecgId);
		DoctorEcg de = new DoctorEcg();
		de.setDoctorId(docId);
		de.setEcgId(ecgId);
		de.setCustomerId(ecg.getCustomerId());
		de.setStatus(0);
		return doctorEcgDao.insert(de) != null;
	}

	@Override
	public DataModel loadEcgData(String ecgId) {
		EcgData ecg = ecgDataDao.findById(ecgId);
		String filepath = fileTransferService.retrieveFtpFile(
				ecg.getCustomerId(), ecg.getFileLocation());
		return new DataDecoder().getData(filepath);
	}
	
	@Override
	public String addEcg(EcgData ecg) {
		return ecgDataDao.insert(ecg);
	}

	public void setEcgMixedDao(EcgMixedDao ecgMixedDao) {
		this.ecgMixedDao = ecgMixedDao;
	}

	public void setEcgDataDao(EcgDataDao ecgDataDao) {
		this.ecgDataDao = ecgDataDao;
	}

	public void setDoctorEcgDao(DoctorEcgDao doctorEcgDao) {
		this.doctorEcgDao = doctorEcgDao;
	}

	public void setFileTransferService(FileTransferService fileTransferService) {
		this.fileTransferService = fileTransferService;
	}
}
