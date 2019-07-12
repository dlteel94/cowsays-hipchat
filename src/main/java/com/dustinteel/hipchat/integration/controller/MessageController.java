package com.dustinteel.hipchat.integration.controller;

import org.codehaus.plexus.util.cli.Commandline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dustinteel.hipchat.integration.model.HipchatMessage;
import com.dustinteel.hipchat.integration.model.Incoming;
import com.dustinteel.hipchat.integration.service.ArgumentParsingService;
import com.dustinteel.hipchat.integration.service.CowsaysService;
import com.dustinteel.hipchat.integration.service.FortuneService;

import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;

@RestController
public class MessageController {
	
	private final String COWSAY_COMMAND = "/cowsay";
	private final String FORTUNE_OPTION = "-f";
	private final String TEXT_OPTION = "-t";
	private final String HELP_OPTION = "-h";
	
	@Autowired
	CowsaysService cowsaysService;
	
	@Autowired
	FortuneService fortuneService;
	
	@Autowired
	ArgumentParsingService argumentParsingService;
	
	@PostMapping("/message-webhook")
	public HipchatMessage processMessage(@RequestBody Incoming incoming) throws ArgumentParserException, Exception {
		String[] message = incoming.getItem().getIncomingMessage().getMessage().split("\\s+", 2);
		String returnMessage;
		// make sure it starts with /cowsay
		if (!message[0].trim().equalsIgnoreCase(COWSAY_COMMAND)) {
			return createMessage(false, false, "Your command must start with '/cowsay', and contain a command or phrase after.", "red");
		}
		
		// TODO: Add more functionality here
		// If second token from message is '-f', then generate a fortune and return it in cowsay format.
		
		Namespace namespace = argumentParsingService.parseArguments(Commandline.translateCommandline(message[2]));
		if (namespace.getBoolean(FORTUNE_OPTION)) {
			returnMessage = fortuneService.generateFortune();
		} else if (namespace.getString(TEXT_OPTION) != null){
			// Return a cowsay with entered message
			returnMessage = namespace.getString(TEXT_OPTION);
		} else if (namespace.getBoolean(HELP_OPTION)) {
			returnMessage = argumentParsingService.getHelp();
		} else {
			returnMessage = "I'm sorry, I couldn't find any valid arguments in your command.  Please check your command and try again.";
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
