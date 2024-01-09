package com.example.demo.hoteles.model;

import java.util.Map;

public class PropertiesHotels {
	
	public PropertiesHotels(String msg, String buildVersion, Map<String, String> mailDetails) {
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
	private String msg;
	private String buildVersion;
	private Map<String, String> mailDetails;

}
