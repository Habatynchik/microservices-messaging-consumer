package ua.epam.microservicesmessagingconsumer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.epam.microservicesmessagingconsumer.model.entity.User;
import ua.epam.microservicesmessagingconsumer.model.repository.UserRepository;

@Service
@Slf4j
public class ConsumerService {
    private final UserRepository userRepository;

    @Autowired
    public ConsumerService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public Long receivedMessage(User user) {
        User save = userRepository.save(user);
        log.info("persisted " + save);
        log.info("User Details Received is.. " + user);
        log.info("User Returned is.. " + save);
        return save.getId();
    }
}
