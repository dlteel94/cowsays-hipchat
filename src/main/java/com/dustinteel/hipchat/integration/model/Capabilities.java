package com.dustinteel.hipchat.integration.model;

import java.util.List;

public class Capabilities {
	private HipchatApiConsumer hipchatApiConsumer;
	private List<Webhook> webhook;
	
	public HipchatApiConsumer getHipchatApiConsumer() {
		return hipchatApiConsumer;
	}

	public void setHipchatApiConsumer(HipchatApiConsumer hipchatApiConsumer) {
		this.hipchatApiConsumer = hipchatApiConsumer;
	}

	public List<Webhook> getWebhook() {
		return webhook;
	}

	public void setWebhook(List<Webhook> webhook) {
		this.webhook = webhook;
	}
}
