package com.example;

import java.security.Principal;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@Configuration
@EnableOAuth2Sso
@RestController
public class ClientApplication {
	
	private final static Logger logger = LoggerFactory.getLogger(ClientApplication.class.getSimpleName());
	
	@RequestMapping("/")
	public String home(Principal user) {
		return "Hello " + user.getName();
	}

	public static void main(String[] args) {
		ApplicationContext context = new SpringApplicationBuilder(ClientApplication.class)
		        .run(args);
		        
		logger.info("Event = 'Started application', app = {}, springProfile = {}", 
				ClientApplication.class.getSimpleName(), Arrays.toString(context.getEnvironment().getActiveProfiles()));
	}
}
