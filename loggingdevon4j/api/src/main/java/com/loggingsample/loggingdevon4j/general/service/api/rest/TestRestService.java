package com.loggingsample.loggingdevon4j.general.service.api.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * TODO snesarmo This type ...
 *
 */
@Path("/testrest/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface TestRestService {

  // @GET
  // @Path("/hello/")
  // public String sayHello();

  @GET
  @Path("/response/")
  public String showResponse();

  @GET
  @Path("/verification")
  public String verifyServiceWork();

  @GET
  @Path("/showLogs")
  public String returnLogs(HttpServletRequest request, HttpServletResponse response);
}
