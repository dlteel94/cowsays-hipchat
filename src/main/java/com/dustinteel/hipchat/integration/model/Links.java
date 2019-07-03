package com.dustinteel.hipchat.integration.model;

public class Links {
	private String self;
	private String participants;
	private String webhooks;

	public String getSelf() {
		return self;
	}

	public void setSelf(String self) {
		this.self = self;
	}

	public String getParticipants() {
		return participants;
	}

	public void setParticipants(String participants) {
		this.participants = participants;
	}

	public String getWebhooks() {
		return webhooks;
	}

	public void setWebhooks(String webhooks) {
		this.webhooks = webhooks;
	}
}
