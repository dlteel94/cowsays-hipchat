package com.dustinteel.hipchat.integration.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dustinteel.hipchat.integration.model.Capabilities;
import com.dustinteel.hipchat.integration.model.HipchatApiConsumer;
import com.dustinteel.hipchat.integration.model.Installable;
import com.dustinteel.hipchat.integration.model.IntegrationDescriptor;

@Service
public class ConfigurationService {
	public IntegrationDescriptor getDescriptor() {
		Installable installable = new Installable();
		installable.setAllowGlobal(false);
		installable.setAllowRoom(true);
		installable.setCallbackUrl("https://cowsays-integration.herokuapp.com/installed-callback");
		
		HipchatApiConsumer hipchatApiConsumer = new HipchatApiConsumer();
		String[] scopesArray = {"send_notification"};
		List<String> scopes = new ArrayList<>(Arrays.asList(scopesArray));
		hipchatApiConsumer.setScopes(scopes);
		
		Capabilities capabilities = new Capabilities();
		capabilities.setInstallable(installable);
		capabilities.setHipchatApiConsumer(hipchatApiConsumer);
		
		IntegrationDescriptor integrationDescriptor = new IntegrationDescriptor();
		integrationDescriptor.setCapabilities(capabilities);
		integrationDescriptor.setKey("com.dustinteel.hipchat.integration");
		integrationDescriptor.setName("Cowsays");
		integrationDescriptor.setDescription("Integration that allows users to interact with the linux cowsay command.");
		
		return integrationDescriptor;
	}
}
