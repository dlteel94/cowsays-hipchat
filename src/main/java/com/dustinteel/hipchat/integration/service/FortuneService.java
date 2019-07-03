package com.dustinteel.hipchat.integration.service;

import java.util.Locale;

import org.springframework.stereotype.Service;

import jfortune.Fortune;

@Service
public class FortuneService {
	public String generateFortune() {
		Fortune fortune = new Fortune(Locale.ENGLISH);
		return fortune.getCookie().getText();
	}
}
 