/*
 * Copyright (c) 2017  All rights reserved.
 */

package com.poc.digital.kafka.producer.service;

/**
 * User service Interface
 */
import com.poc.digital.kafka.producer.model.Company;
import com.poc.digital.kafka.producer.model.UserObj;

public interface UserService {

	//Create User - Called by the Create user REST API
	public void createUser(UserObj userRequest);

	//Update User - Called by the Update user REST API
	public void updateUser(UserObj userRequest);

	//Create Company - Called by the Create company REST API
	public void createCompany(Company companyRequest);

	//Update Company - Called by the Update company REST API
	public void updateCompany(Company companyRequest);


}
