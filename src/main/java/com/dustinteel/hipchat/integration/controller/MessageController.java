package com.dustinteel.hipchat.integration.controller;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dustinteel.hipchat.integration.model.HipchatMessage;
import com.dustinteel.hipchat.integration.model.Incoming;
import com.dustinteel.hipchat.integration.service.CowsaysService;

@RestController
public class MessageController {
	
	private final String COWSAY_COMMAND = "/cowsay";
	
	@Autowired
	CowsaysService cowsaysService;
	
	@RequestMapping("/test")
	public String getCowsayMessage() {
		ProcessBuilder pb = new ProcessBuilder("cowsay","I work!");
		String ayy = "Something went wrong!";
		try {
			ayy = IOUtils.toString(pb.start().getInputStream(), "UTF-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return String.format("<pre>%s</pre>",ayy);
	}
	
	@PostMapping("/message-webhook")
	public HipchatMessage processMessage(@RequestBody Incoming incoming) throws IOException {
		String message = incoming.getItem().getIncomingMessage().getMessage();
		if (message.indexOf(COWSAY_COMMAND) == 0) {
			message = message.substring(COWSAY_COMMAND.length(), message.length());
		} else {
			message = "Cannot do things.";
		}
		HipchatMessage hipchatMessage = new HipchatMessage();
		hipchatMessage.setMessage(String.format("<pre>%s</pre>", cowsaysService.generateCowsay(message)));
		hipchatMessage.setColor("GREEN");
		hipchatMessage.setMessage_format("html");
		hipchatMessage.setNotify(true);
		return hipchatMessage;
	}
}
