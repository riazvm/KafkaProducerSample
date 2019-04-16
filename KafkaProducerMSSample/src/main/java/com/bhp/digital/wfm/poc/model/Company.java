package com.bhp.digital.wfm.poc.model;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
/**
 * Company Object
 */

@Data
@JsonInclude(Include.NON_NULL)
public class Company   {
	 private String companyID = null;
	 private String companyName = null;
	 private String contractorAdminName = null;
	 private String contractorAdminEmail = null;
	
}
