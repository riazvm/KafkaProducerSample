package com.bhp.digital.wfm.poc.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.bhp.digital.wfm.poc.model.CompanyRequest;
import com.bhp.digital.wfm.poc.model.User;
import com.bhp.digital.wfm.poc.model.UserRequest;
import com.bhp.digital.wfm.poc.service.UserService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

/**
 * Controller class. 
 * REST API's - createUser , UpdateUser, createComapny, updateCompany
 */
 

@RestController
@EnableWebMvc
public class UsersApiController  {

	@Autowired
	private UserService userService;
	
	@Autowired
	public UsersApiController(UserService userService){
		this.userService=userService;
	}
	
	/**
	 * REST URI for create User -- JSON
	 * Method implementation of the HBase operations
	 * @param UserRequest
	 * @return ResponseEntity
	 */	
	  @RequestMapping(method = RequestMethod.POST,value = "/users/create",
	          consumes = MediaType.APPLICATION_JSON_VALUE)
	  public ResponseEntity<Void> createUser(@Context HttpServletRequest requestDto,@RequestBody UserRequest userRequest ) {
		  userService.createUser(userRequest.getUser());
		  return new ResponseEntity<Void>(HttpStatus.OK);
	  }
	/**
	 * REST URI for Update User -- JSON
	 * Method implementation of the HBase operations
	 * @param UserRequest
	 * @return ResponseEntity
	 */	
	  @RequestMapping(method = RequestMethod.POST, value = "/users/update",
	          consumes = MediaType.APPLICATION_JSON_VALUE)
	  public ResponseEntity<Void> updateUser(@Context HttpServletRequest requestDto,@RequestBody UserRequest userRequest ) {
		  userService.updateUser(userRequest.getUser());
		  return new ResponseEntity<Void>(HttpStatus.OK);
	  }
		/**
		 * REST URI for create Multiple Users -- JSON
		 * Method implementation of the HBase operations
		 * @param UserRequest
		 * @return ResponseEntity
		 */	
	  @RequestMapping(method = RequestMethod.POST, value = "/users/createUsingArgs",
	          consumes = MediaType.APPLICATION_JSON_VALUE)
	  public ResponseEntity<Void> createUsersWithListInput(@Context HttpServletRequest requestDto,@RequestBody List<User> userRequest ) {
		  return new ResponseEntity<Void>(HttpStatus.OK);
	  }
	/**
	 * REST URI for create Company -- JSON
	 * Method implementation of the HBase operations
	 * @param CompanyRequest
	 * @return ResponseEntity
	 */	
	  @RequestMapping(method = RequestMethod.POST,value = "/company/create",
	          consumes = MediaType.APPLICATION_JSON_VALUE)
	  public ResponseEntity<Void> createCompany(@Context HttpServletRequest requestDto,@RequestBody CompanyRequest companyRequest ) {
		  userService.createCompany(companyRequest.getCompany());
		  return new ResponseEntity<Void>(HttpStatus.OK);
	  }
	/**
	 * REST URI for Update Company -- JSON
	 * Method implementation of the HBase operations
	 * @param CompanyRequest
	 * @return ResponseEntity
	 */		  
	  @RequestMapping(method = RequestMethod.POST, value = "/company/update",
	          consumes = MediaType.APPLICATION_JSON_VALUE)
	  public ResponseEntity<Void> updateCompany(@Context HttpServletRequest requestDto,@RequestBody CompanyRequest companyRequest ) {
		  userService.updateCompany(companyRequest.getCompany());
		  return new ResponseEntity<Void>(HttpStatus.OK);
	  }

}
