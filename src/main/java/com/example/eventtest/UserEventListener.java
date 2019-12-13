package com.example.eventtest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserEventListener {

    @EventListener
    public void processUserCreatedEvent(UserCreatedEvent event) {
        log.info("User event processed" + event.toString());
    }
}
