package com.dustinteel.hipchat.integration.model;

public class Installable {
	private boolean allowGlobal;
	private boolean allowRoom;
	private String callbackUrl;
	public boolean isAllowGlobal() {
		return allowGlobal;
	}
	public void setAllowGlobal(boolean allowGlobal) {
		this.allowGlobal = allowGlobal;
	}
	public boolean isAllowRoom() {
		return allowRoom;
	}
	public void setAllowRoom(boolean allowRoom) {
		this.allowRoom = allowRoom;
	}
	public String getCallbackUrl() {
		return callbackUrl;
	}
	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}
}
