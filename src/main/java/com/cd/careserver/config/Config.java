package com.cd.careserver.config;

import java.util.ResourceBundle;

public class Config {
	private static ResourceBundle configuration = ResourceBundle
			.getBundle("config");
	
	public static String getFtpUrl() {
		return configuration.getString("ftp.server.url");
	}
	
	public static String getFtpUsername() {
		return configuration.getString("ftp.user.name");
	}
	
	public static String getFtpPassword() {
		return configuration.getString("ftp.user.password");
	}
	
	public static String getEcgLocalDir(){
		return configuration.getString("ecg.local.dir");
	}
}
