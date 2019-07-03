package com.dustinteel.hipchat.integration.service;

import org.springframework.stereotype.Service;

import jfortune.Fortune;

@Service
public class FortuneService {
	public String generateFortune() {
		Fortune fortune = new Fortune();
		return fortune.getCookie().getText();
	}
}
 