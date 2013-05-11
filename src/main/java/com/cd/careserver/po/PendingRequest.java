package com.cd.careserver.po;

import java.util.Date;

public class PendingRequest {
	
	private String id;
	private int type;
	private String message;
	private String cmd;
	private int fromType;
	private String fromId;
	private int toType;
	private String toId;
	private Date creationTime;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCmd() {
		return cmd;
	}
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	public int getFromType() {
		return fromType;
	}
	public void setFromType(int fromType) {
		this.fromType = fromType;
	}
	public String getFromId() {
		return fromId;
	}
	public void setFromId(String fromId) {
		this.fromId = fromId;
	}
	public int getToType() {
		return toType;
	}
	public void setToType(int toType) {
		this.toType = toType;
	}
	public String getToId() {
		return toId;
	}
	public void setToId(String toId) {
		this.toId = toId;
	}
	public Date getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
}
