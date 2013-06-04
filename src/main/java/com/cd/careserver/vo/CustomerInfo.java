package com.cd.careserver.vo;

import java.io.Serializable;
import java.util.Date;

import com.cd.careserver.dict.Sex;
import com.cd.careserver.po.Customer;
import com.cd.careserver.po.DoctorCustomer;

public class CustomerInfo implements Serializable {
	private static final long serialVersionUID = -1309879755698194299L;
	
	// basic customer fields
	private String id;
	private String userId;
	private String name;
	private int type;
	private String iden;
	private String nickName;
	private int sex;
	private int age;
	private String cellPhone;
	private String phone;
	private Date creationTime;
	
	// extends fields
	private String sexStr;
	private boolean monitored;
	
	// relation mark
	private int mark;
	private String note;
	
	// doc info
	private String docId;
	private String docName;
	
	public CustomerInfo(){}
	
	public CustomerInfo(Customer c){
		if (c == null){
			return ;
		}
		setId(c.getId());
		setUserId(c.getUserId());
		setName(c.getName());
		setType(c.getType());
		setIden(c.getIden());
		setNickName(c.getNickName());
		setSex(c.getSex());
		setAge(c.getAge());
		setCellPhone(c.getCellPhone());
		setPhone(c.getPhone());
		setCreationTime(c.getCreationTime());
	}
	
	public void collect(DoctorCustomer dc){
		if (dc == null){
			return ;
		}
		setMark(dc.getMark());
		setNote(dc.getNote());
		this.monitored = true;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getIden() {
		return iden;
	}

	public void setIden(String iden) {
		this.iden = iden;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
		this.sexStr = Sex.valueOf(sex).toString();
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public String getSexStr() {
		return sexStr;
	}

	public void setSexStr(String sexStr) {
		this.sexStr = sexStr;
	}

	public boolean isMonitored() {
		return monitored;
	}

	public void setMonitored(boolean monitored) {
		this.monitored = monitored;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getDocId() {
		return docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}
}
