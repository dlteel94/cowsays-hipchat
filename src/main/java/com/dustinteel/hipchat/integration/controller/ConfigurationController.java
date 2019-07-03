package com.dustinteel.hipchat.integration.controller;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dustinteel.hipchat.integration.model.IntegrationDescriptor;
import com.dustinteel.hipchat.integration.service.ConfigurationService;

@RestController
public class ConfigurationController {
	
	@Autowired
	ConfigurationService configurationService;
	
	@Autowired
	private HttpServletRequest request;
	
	@GetMapping("/descriptor")
	public IntegrationDescriptor getIntegrationDescriptor() {
		return configurationService.getDescriptor();
	}
	
	@PostMapping("/installed-callback")
	public HttpStatus installedCallback() throws IOException {
		//TODO: DO something here
		System.out.println(request.getReader().lines().collect(Collectors.joining(System.lineSeparator())));
		return HttpStatus.OK;
	}
}
