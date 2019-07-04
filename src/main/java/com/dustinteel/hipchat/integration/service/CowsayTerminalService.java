package com.dustinteel.hipchat.integration.service;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

@Service
public class CowsayTerminalService {

	public String generateCowsay() {
		ProcessBuilder pb = new ProcessBuilder("/bin/sh", "-c", "fortune | cowsay");
		String msg = "Something went wrong!";
		try {
			msg = IOUtils.toString(pb.start().getInputStream(), "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return String.format("<pre>%s</pre>",msg);
	}
}
