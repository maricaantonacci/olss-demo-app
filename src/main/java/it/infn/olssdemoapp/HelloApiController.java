package it.infn.olssdemoapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.annotation.Timed;

@RestController
public class HelloApiController {

  private final OlssProperties properties;

  public HelloApiController(OlssProperties properties) {
    this.properties = properties;
  }

  @GetMapping("/api/hello")
  @Timed
  public String sayHello() {
    return String.format("Hello world (from %s)!", properties.getUuid());
  }

}
