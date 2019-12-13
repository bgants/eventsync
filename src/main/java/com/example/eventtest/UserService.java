package com.example.eventtest;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    ApplicationEventPublisher applicationEventPublisher;

    @Transactional
    public User addUser(User user) {
        User newUser = userRepository.save(user);
        UserCreatedEvent userCreatedEvent = new UserCreatedEvent(user);
        applicationEventPublisher.publishEvent(userCreatedEvent);
        return newUser;
    }
}
