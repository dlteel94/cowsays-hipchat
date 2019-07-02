package com.dustinteel.hipchat.integration.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dustinteel.hipchat.integration.model.Capabilities;
import com.dustinteel.hipchat.integration.model.HipchatApiConsumer;
import com.dustinteel.hipchat.integration.model.Installable;
import com.dustinteel.hipchat.integration.model.IntegrationDescriptor;
import com.dustinteel.hipchat.integration.model.Links;
import com.dustinteel.hipchat.integration.model.Vendor;
import com.dustinteel.hipchat.integration.model.Webhook;

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
		
		Webhook webhook = new Webhook();
		webhook.setUrl("https://cowsays-integration.herokuapp.com/message-webhook");
		webhook.setEvent("room_message");
		webhook.setPattern(".*");
		webhook.setName("Cowsays");
		webhook.setAuthentication("jwt");
		
		Webhook[] webhooksArray = {webhook};
		
		List<Webhook> webhooks = Arrays.asList(webhooksArray);
		
		Capabilities capabilities = new Capabilities();
		capabilities.setHipchatApiConsumer(hipchatApiConsumer);
		capabilities.setWebhook(webhooks);
		Vendor vendor = new Vendor();
		vendor.setName("Dustin Teel");
		vendor.setUrl("https://github.com/dustinteel");
		
		Links links = new Links();
		links.setSelf("https://cowsays-integration.herokuapp.com/descriptor");
		
		IntegrationDescriptor integrationDescriptor = new IntegrationDescriptor();
		integrationDescriptor.setCapabilities(capabilities);
		integrationDescriptor.setKey("com.dustinteel.hipchat.integration");
		integrationDescriptor.setName("Cowsays");
		integrationDescriptor.setDescription("Integration that allows users to interact with the linux cowsay command.");
		integrationDescriptor.setLinks(links);
		integrationDescriptor.setVendor(vendor);
		
		return integrationDescriptor;
	}
}
