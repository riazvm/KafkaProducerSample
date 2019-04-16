package com.poc.digital.kafka.producer.model;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
/**
 * User Wrapper Object
 */
@Data
@JsonInclude(Include.NON_NULL)
public class UserRequest {
	
	private UserObj user;

	public UserObj getUser() {
		return user;
	}

	public void setUser(UserObj user) {
		this.user = user;
	}

}