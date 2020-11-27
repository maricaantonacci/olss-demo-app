package it.infn.olssdemoapp;

import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.LivenessState;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationStateController {

  private final ApplicationEventPublisher eventPublisher;

  public ApplicationStateController(ApplicationEventPublisher ep) {
    this.eventPublisher = ep;
  }

  @PostMapping("/api/application-state/refuse-traffic")
  public void refuseTraffic() {
    AvailabilityChangeEvent.publish(eventPublisher, this, ReadinessState.REFUSING_TRAFFIC);
  }

  @PostMapping("/api/application-state/accept-traffic")
  public void acceptTraffic() {
    AvailabilityChangeEvent.publish(eventPublisher, this, ReadinessState.ACCEPTING_TRAFFIC);
  }

  @PostMapping("/api/application-state/break")
  public void breakApplicationState() {
    AvailabilityChangeEvent.publish(eventPublisher, this, LivenessState.BROKEN);
  }
}
