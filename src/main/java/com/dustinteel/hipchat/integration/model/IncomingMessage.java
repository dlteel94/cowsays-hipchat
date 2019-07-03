package com.dustinteel.hipchat.integration.model;

import java.time.ZonedDateTime;

public class IncomingMessage {
	private ZonedDateTime date;
	private String mention_name;
	private String name;
	private String version;
	private IncomingFrom from;
	
	public ZonedDateTime getDate() {
		return date;
	}
	public void setDate(ZonedDateTime date) {
		this.date = date;
	}
	public String getMention_name() {
		return mention_name;
	}
	public void setMention_name(String mention_name) {
		this.mention_name = mention_name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public IncomingFrom getFrom() {
		return from;
	}
	public void setFrom(IncomingFrom from) {
		this.from = from;
	}
	
	
}
