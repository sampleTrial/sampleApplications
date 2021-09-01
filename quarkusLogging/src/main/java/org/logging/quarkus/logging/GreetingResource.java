package org.logging.quarkus.logging;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Path("/hello")
public class GreetingResource {

    @GET
    @Path("/sayHello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }

    @GET
    @Path("/returnLog")
    @Produces(MediaType.TEXT_PLAIN)
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