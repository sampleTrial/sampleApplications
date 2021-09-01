package com.example.logging.springlogging;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class SpringloggingApplicationTests {

  @Test
  void contextLoads() {

  }

  @LocalServerPort
  private int port;
  
  @Autowired
  private SampleLogging sampleLogging;

  @Test
  public void testGreeting() throws Exception {

    ResponseEntity<String> entity = this.sampleLogging.getForEntity(
        "http://localhost:" + this.port + "/eureka/apps", String.class).
    then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
  }

}
