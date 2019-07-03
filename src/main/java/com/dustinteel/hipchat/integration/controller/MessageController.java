package com.dustinteel.hipchat.integration.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dustinteel.hipchat.integration.model.HipchatMessage;
import com.dustinteel.hipchat.integration.model.Incoming;
import com.dustinteel.hipchat.integration.service.CowsaysService;
import com.dustinteel.hipchat.integration.service.FortuneService;

@RestController
public class MessageController {
	
	private final String COWSAY_COMMAND = "/cowsay";
	private final String FORTUNE_OPTION = "-f";
	
	@Autowired
	CowsaysService cowsaysService;
	
	@Autowired
	FortuneService fortuneService;
	
	@PostMapping("/message-webhook")
	public HipchatMessage processMessage(@RequestBody Incoming incoming) throws IOException {
		String[] message = incoming.getItem().getIncomingMessage().getMessage().split("\\s+", 3);
		String returnMessage;
		// make sure it starts with /cowsay
		if (!message[0].equalsIgnoreCase(COWSAY_COMMAND)) {
			return createMessage(false, false, "Your command must start with '/cowsay', and contain a command or phrase after.", "red");
		}
		
		// TODO: Add more functionality here
		// If second token from message is '-f', then generate a fortune and return it in cowsay format.
		if (message[1].trim().equalsIgnoreCase(FORTUNE_OPTION)) {
			returnMessage = fortuneService.generateFortune();
		} else {
			// Return a cowsay with entered message
			returnMessage = incoming.getItem().getIncomingMessage().getMessage().split("\\s+, 2")[1];
		}
		return createMessage(true, true, returnMessage, "green");
	}
	
	private HipchatMessage createMessage(boolean html, boolean wrapInCowsay, String text, String color) {
		HipchatMessage message = new HipchatMessage();
		message.setColor(color);
		message.setNotify(false);
		if(html) {
			if(wrapInCowsay) {
				message.setMessage(String.format("<pre>%s</pre>", cowsaysService.generateCowsay(text)));
			} else {
				message.setMessage(String.format("<pre>%s</pre>", text));
			}
			message.setMessage_format("html");
		} else {
			message.setMessage(text);
			message.setMessage_format("text");
		}
		return message;
	}
}
