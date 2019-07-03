package com.dustinteel.hipchat.integration.model;

public class IncomingWebhook {
	private String event;
	private String oauth_client_id;
	private String webhook_id;
	private IncomingItem item;
	
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public String getOauth_client_id() {
		return oauth_client_id;
	}
	public void setOauth_client_id(String oauth_client_id) {
		this.oauth_client_id = oauth_client_id;
	}
	public String getWebhook_id() {
		return webhook_id;
	}
	public void setWebhook_id(String webhook_id) {
		this.webhook_id = webhook_id;
	}
	public IncomingItem getItem() {
		return item;
	}
	public void setItem(IncomingItem item) {
		this.item = item;
	}
	
	
}
