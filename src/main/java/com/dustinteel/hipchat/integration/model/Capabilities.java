package com.dustinteel.hipchat.integration.model;

public class Capabilities {
	private Installable installable;
	private HipchatApiConsumer hipchatApiConsumer;

	public HipchatApiConsumer getHipchatApiConsumer() {
		return hipchatApiConsumer;
	}

	public void setHipchatApiConsumer(HipchatApiConsumer hipchatApiConsumer) {
		this.hipchatApiConsumer = hipchatApiConsumer;
	}

	public Installable getInstallable() {
		return installable;
	}

	public void setInstallable(Installable installable) {
		this.installable = installable;
	}
}
