package com.loggingsample.loggingdevon4j.general.service.impl.rest;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.devonfw.module.service.common.api.client.ServiceClientFactory;
import com.loggingsample.loggingdevon4j.general.service.api.rest.TestRestService;

/**
 * TODO snesarmo This type ...
 *
 */
@Named("TestRestService")
public class TestRestServiceImpl implements TestRestService {

  static Logger logger = Logger.getLogger(TestRestServiceImpl.class.getName());

  @Inject
  private ServiceClientFactory serviceClientFactory;

  @Override
  public String showResponse() {

    String response = "logging inside devon4j application";

    return response;
  }

  @Override
  public String verifyServiceWork() {

    return "this method of client service is working";
  }

  @Override
  public String returnLogs(HttpServletRequest request, HttpServletResponse response) {

    long startTime = System.nanoTime();
    // trace -- we can get the whole logging details of particular event (end time and start time)
    // logger.error("started error giving");
    String currentUrl = request.getRequestURL().toString();

    int statusCode = response.getStatus();

    System.out.println(statusCode);

    long endTime = System.nanoTime();

    long duration = TimeUnit.MILLISECONDS.convert(endTime - startTime, TimeUnit.NANOSECONDS);

    logger.log(Level.INFO, "logging: {0} {1} {2} {3}", new Object[] { currentUrl, statusCode, duration, endTime });

    return "logging starts here";

  }

}