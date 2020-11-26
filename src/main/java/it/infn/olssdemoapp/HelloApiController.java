package it.infn.olssdemoapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.annotation.Timed;

@RestController
@RequestMapping(path = "/api")
public class HelloApiController {

  public static final int TEN_MB = 10 * 1024;

  private static final MemoryHog memoryHog = new MemoryHog();

  final OlssProperties properties;

  public HelloApiController(OlssProperties properties) {
    this.properties = properties;
  }

  @GetMapping("/hello")
  @Timed
  public String sayHello() {
    return String.format("Hello world (from %s)!", properties.getUuid());
  }


  @PostMapping("/memory/grow")
  @Timed
  public String growMemory() {
    memoryHog.addChunk(TEN_MB);
    return String.format("%d", memoryHog.size());
  }

  @PostMapping("/memory/clear")
  @Timed
  public String clearMemory() {
    memoryHog.clearChunks();
    return String.format("%d", memoryHog.size());
  }

}
