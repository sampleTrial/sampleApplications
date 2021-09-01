package com.example.logging.springlogging;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO ayudixit This type ...
 *
 */
@RestController
public class SampleLogging {

  static Logger logger = Logger.getLogger(SampleLogging.class.getName());

  @RequestMapping("/showCurrentUrl")
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

    return "logging starts here" + request.getRequestURL().toString();

  }
}