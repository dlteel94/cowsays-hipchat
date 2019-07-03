package com.dustinteel.hipchat.integration.model;

public class HipchatMessage {
	private String message;
	private String message_format;
	private String color;
	private boolean notify;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage_format() {
		return message_format;
	}

	public void setMessage_format(String message_format) {
		this.message_format = message_format;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isNotify() {
		return notify;
	}

	public void setNotify(boolean notify) {
		this.notify = notify;
	}
}
