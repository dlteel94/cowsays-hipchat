package com.dustinteel.hipchat.integration.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
	@PostMapping("/message-webhook")
	public HttpStatus processMessage() {
		return HttpStatus.OK;
	}
}
