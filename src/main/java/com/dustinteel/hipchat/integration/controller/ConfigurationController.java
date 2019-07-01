package com.dustinteel.hipchat.integration.controller;

import org.json.JSONException;
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
	
	@GetMapping("/descriptor")
	public IntegrationDescriptor getIntegrationDescriptor() throws JSONException {
		return configurationService.getDescriptor();
	}
	
	@PostMapping("/installed-callback")
	public HttpStatus installedCallback() {
		//TODO: DO something here
		return HttpStatus.OK;
	}
}
