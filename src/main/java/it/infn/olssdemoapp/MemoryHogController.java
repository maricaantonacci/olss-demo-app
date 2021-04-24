package it.infn.olssdemoapp;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.annotation.Timed;

@RestController
public class MemoryHogController {

  public static final int ONE_HUNDRED_MB = 100 * 1024;

  private final MemoryHog memoryHog;

  public MemoryHogController(MemoryHog mh) {
    this.memoryHog = mh;
  }

  @PostMapping("/api/memory/grow")
  @Timed
  public String growMemory() {
    memoryHog.addChunk(ONE_HUNDRED_MB);
    return String.format("%d", memoryHog.size());
  }

  @PostMapping("/api/memory/clear")
  @Timed
  public String clearMemory() {
    memoryHog.clearChunks();
    return String.format("%d", memoryHog.size());
  }

}
