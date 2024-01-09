package com.example.demo.reserva.model;

import java.util.Map;

public class PropertiesReservation {
	
	private String msg;
	private String buildVersion;
	private Map<String, String> mailDetails;
	
	public PropertiesReservation(String msg, String buildVersion, Map<String, String> mailDetails) {
		super();
		this.msg = msg;
		this.buildVersion = buildVersion;
		this.mailDetails = mailDetails;
	}
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getBuildVersion() {
		return buildVersion;
	}
	public void setBuildVersion(String buildVersion) {
		this.buildVersion = buildVersion;
	}
	public Map<String, String> getMailDetails() {
		return mailDetails;
	}
	public void setMailDetails(Map<String, String> mailDetails) {
		this.mailDetails = mailDetails;
	}

}
