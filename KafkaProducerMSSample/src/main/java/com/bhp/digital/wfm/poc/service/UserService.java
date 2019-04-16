/*
 * Copyright (c) 2017 Infosys Co. All rights reserved.
 */

package com.bhp.digital.wfm.poc.service;

/**
 * User service Interface
 */
import com.bhp.digital.wfm.poc.model.Company;
import com.bhp.digital.wfm.poc.model.User;

public interface UserService {

	//Create User - Called by the Create user REST API
	public void createUser(User userRequest);

	//Update User - Called by the Update user REST API
	public void updateUser(User userRequest);

	//Create Company - Called by the Create company REST API
	public void createCompany(Company companyRequest);

	//Update Company - Called by the Update company REST API
	public void updateCompany(Company companyRequest);


}
