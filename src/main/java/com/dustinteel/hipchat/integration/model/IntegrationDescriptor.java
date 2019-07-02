package com.dustinteel.hipchat.integration.model;

public class IntegrationDescriptor {
	private String name;
	private String key;
	private String description;
	private Capabilities capabilities;
	private Vendor vendor;
	private Links links;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Capabilities getCapabilities() {
		return capabilities;
	}
	public void setCapabilities(Capabilities capabilites) {
		this.capabilities = capabilites;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Vendor getVendor() {
		return vendor;
	}
	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
	public Links getLinks() {
		return links;
	}
	public void setLinks(Links links) {
		this.links = links;
	}
}
