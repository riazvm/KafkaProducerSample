package com.bhp.digital.wfm.poc; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * Main class for Inventory micro service.
 */
@SpringBootApplication
//@EnableDiscoveryClient
@ComponentScan({"com.bhp.digital"})
public class WorkForceUserApplication {

  @Autowired
 // CassandraUtil cassandraUtil;

  @SuppressWarnings({"squid:S2095"})
  public static void main(String... args) {
    SpringApplication.run(WorkForceUserApplication.class, args);
  }
}
