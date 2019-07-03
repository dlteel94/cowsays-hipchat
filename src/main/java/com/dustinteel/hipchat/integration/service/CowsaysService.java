package com.dustinteel.hipchat.integration.service;

import org.springframework.stereotype.Service;

import com.github.ricksbrown.cowsay.Cowsay;

@Service
public class CowsaysService {
	public String generateCowsay(String cowsay) {
		return Cowsay.say(new String[] {cowsay});
	}
}
