/*
 * Copyright (c) 2017 JCPenney Co. All rights reserved.
 */

package com.bhp.digital.wfm.poc.service.impl;



import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bhp.digital.wfm.poc.model.Company;
import com.bhp.digital.wfm.poc.model.User;
import com.bhp.digital.wfm.poc.service.UserService;
import com.bhp.digital.wfm.poc.utils.Producer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Method implementation of the User and Company operations
 * 
 */
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private Producer producer;
	
	@Value("${topics.createUsertopic}")
	private String createUserTopic;
	
	@Value("${topics.updateUsertopic}")
	private String updateUserTopic;
	
	@Value("${topics.createCompanytopic}")
	private String createCompanyTopic;
	
	@Value("${topics.updateCompanytopic}")
	private String updateCompanyTopic;


	/**
	 * This method posts the user message for create user to a Kafka topic
	 * 
	 * @param User 
	 * @return Void
	 */	
	@Override
	public void createUser(User userRequest) {
		
		System.out.println(createJsonString(userRequest));
		System.out.println(createUserTopic);
		if((userRequest.getPersonUniqueID()!=null || userRequest.getPersonUniqueID().length()!=0) && StringUtils.isNumeric( userRequest.getPersonUniqueID()))
		{
			producer.sendMessage(1, createJsonString(userRequest), createUserTopic);
		}
		//consumer.startConsumer();

	}

	/**
	 * This method posts the user message for update user to a Kafka topic
	 * 
	 * @param User 
	 * @return Void
	 */	

	@Override
	public void updateUser(User userRequest) {
		
		System.out.println(createJsonString(userRequest));
		if((userRequest.getPersonUniqueID()!=null || userRequest.getPersonUniqueID().length()!=0) && StringUtils.isNumeric( userRequest.getPersonUniqueID()))
		{
			producer.sendMessage(1, createJsonString(userRequest), updateUserTopic);
		}
	
	}
	/**
	 * This method posts the user message for create company to a Kafka topic
	 * 
	 * @param Company 
	 * @return Void
	 */	

	@Override
	public void createCompany(Company companyRequest) {
		
		System.out.println(createJsonString(companyRequest));
		if((companyRequest.getCompanyID()!=null || companyRequest.getCompanyID().length()!=0) && StringUtils.isNumeric(companyRequest.getCompanyID()))
		{
			producer.sendMessage(1, createJsonString(companyRequest), createCompanyTopic);
		}
		//consumer.startConsumer();

	}
	/**
	 * This method posts the user message for update company to a Kafka topic
	 * 
	 * @param Company 
	 * @return Void
	 */	

	@Override
	public void updateCompany(Company companyRequest) {
		
		System.out.println(createJsonString(companyRequest));
		if((companyRequest.getCompanyID()!=null || companyRequest.getCompanyID().length()!=0) && StringUtils.isNumeric(companyRequest.getCompanyID()))
		{
			producer.sendMessage(1, createJsonString(companyRequest), updateCompanyTopic);
		}
	
	}
	/**
	 * This method converts an object to a JSON string
	 * 
	 * @param Object 
	 * @return String
	 */	

	public String createJsonString(Object a)
	{
		ObjectMapper objMapper = new ObjectMapper();
		String jsonString= null;
		try {
			jsonString= objMapper.writeValueAsString(a);
		} catch (JsonProcessingException e) {
			System.out.println(e);
		}	
		
		return jsonString;
		
	}


}
