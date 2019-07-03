package com.dustinteel.hipchat.integration.controller;

import java.io.IOException;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dustinteel.hipchat.integration.model.HipchatMessage;
import com.dustinteel.hipchat.integration.model.Incoming;

@RestController
public class MessageController {
	
	@PostMapping("/message-webhook")
	public HipchatMessage processMessage(@RequestBody Incoming incoming) throws IOException {
		String message = incoming.getItem().getIncomingMessage().getMessage();
		if (message.indexOf("/cowsay") == 0) {
			message = message.substring(6, message.length());
		} else {
			message = "Cannot do things.";
		}
		HipchatMessage hipchatMessage = new HipchatMessage();
		hipchatMessage.setMessage(message);
		hipchatMessage.setColor("GREEN");
		hipchatMessage.setMessage_format("html");
		hipchatMessage.setNotify(true);
		return hipchatMessage;
	}
}
