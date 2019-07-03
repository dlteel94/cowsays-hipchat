package com.dustinteel.hipchat.integration.controller;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dustinteel.hipchat.integration.model.Incoming;

@RestController
public class MessageController {
	
	@Autowired
	private HttpServletRequest request;
	
	@PostMapping("/message-webhook")
	public HttpStatus processMessage() throws IOException {
		System.out.println(request.getReader().lines().collect(Collectors.joining(System.lineSeparator())));
		return HttpStatus.OK;
	}
}
