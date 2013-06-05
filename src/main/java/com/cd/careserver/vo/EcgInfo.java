package com.cd.careserver.vo;

import java.util.Date;

import com.cd.careserver.dict.Sex;

public class EcgInfo {

	// ecg_data
	private String id;
	private String customerId;
	private String fileLocation;
	private Date creationTime;
	
	// doctor_ecg
	private String deId;
	private String deDoctorId;
	private String deCustomerId;
	private int deType;
	private int deStatus;
	private String deAnnotation;
	private Date deCreationTime;
	
	// customerInfo
	private String cuName;
	private String cuNickname;
	private Date cuCreationTime;
	private int cuSex;
	private String cuSexStr;
	private String cuIden;
	private int cuAge;
	private String cuCellPhone;
	private String cuPhone;
	
	private boolean read = false;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getFileLocation() {
		return fileLocation;
	}
	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}
	public Date getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	public String getDeId() {
		return deId;
	}
	public void setDeId(String deId) {
		if (deId != null){
			this.read = true;
		}
		this.deId = deId;
	}
	public String getDeDoctorId() {
		return deDoctorId;
	}
	public void setDeDoctorId(String deDoctorId) {
		this.deDoctorId = deDoctorId;
	}
	public String getDeCustomerId() {
		return deCustomerId;
	}
	public void setDeCustomerId(String deCustomerId) {
		this.deCustomerId = deCustomerId;
	}
	public int getDeType() {
		return deType;
	}
	public void setDeType(int deType) {
		this.deType = deType;
	}
	public int getDeStatus() {
		return deStatus;
	}
	public void setDeStatus(int deStatus) {
		this.deStatus = deStatus;
	}
	public String getDeAnnotation() {
		return deAnnotation;
	}
	public void setDeAnnotation(String deAnnotation) {
		this.deAnnotation = deAnnotation;
	}
	public Date getDeCreationTime() {
		return deCreationTime;
	}
	public void setDeCreationTime(Date deCreationTime) {
		this.deCreationTime = deCreationTime;
	}
	public boolean isRead() {
		return read;
	}
	public String getCuName() {
		return cuName;
	}
	public void setCuName(String cuName) {
		this.cuName = cuName;
	}
	public String getCuNickname() {
		return cuNickname;
	}
	public void setCuNickname(String cuNickname) {
		this.cuNickname = cuNickname;
	}
	public Date getCuCreationTime() {
		return cuCreationTime;
	}
	public void setCuCreationTime(Date cuCreationTime) {
		this.cuCreationTime = cuCreationTime;
	}
	public int getCuSex() {
		return cuSex;
	}
	public void setCuSex(int cuSex) {
		this.cuSex = cuSex;
		this.cuSexStr = Sex.valueOf(cuSex).toI18nString();
	}
	public String getCuSexStr() {
		return cuSexStr;
	}
	public void setCuSexStr(String cuSexStr) {
		this.cuSexStr = cuSexStr;
	}
	public String getCuIden() {
		return cuIden;
	}
	public void setCuIden(String cuIden) {
		this.cuIden = cuIden;
	}
	public int getCuAge() {
		return cuAge;
	}
	public void setCuAge(int cuAge) {
		this.cuAge = cuAge;
	}
	public String getCuCellPhone() {
		return cuCellPhone;
	}
	public void setCuCellPhone(String cuCellPhone) {
		this.cuCellPhone = cuCellPhone;
	}
	public String getCuPhone() {
		return cuPhone;
	}
	public void setCuPhone(String cuPhone) {
		this.cuPhone = cuPhone;
	}
}
