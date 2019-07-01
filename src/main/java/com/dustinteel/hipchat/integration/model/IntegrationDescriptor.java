package com.dustinteel.hipchat.integration.model;

public class IntegrationDescriptor {
	private String name;
	private String key;
	private Capabilities capabilities;
	private HipchatApiConsumer hipchatApiConsumer;
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
	public HipchatApiConsumer getHipchatApiConsumer() {
		return hipchatApiConsumer;
	}
	public void setHipchatApiConsumer(HipchatApiConsumer hipchatApiConsumer) {
		this.hipchatApiConsumer = hipchatApiConsumer;
	}
}
