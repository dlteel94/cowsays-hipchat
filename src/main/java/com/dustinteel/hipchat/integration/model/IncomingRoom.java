package com.dustinteel.hipchat.integration.model;

public class IncomingRoom {
	private String id;
	private boolean is_archived;
	private Links links;
	private String name;
	private String privacy;
	private String version;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public boolean isIs_archived() {
		return is_archived;
	}
	public void setIs_archived(boolean is_archived) {
		this.is_archived = is_archived;
	}
	public Links getLinks() {
		return links;
	}
	public void setLinks(Links links) {
		this.links = links;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrivacy() {
		return privacy;
	}
	public void setPrivacy(String privacy) {
		this.privacy = privacy;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	
	
}
