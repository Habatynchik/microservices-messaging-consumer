package ua.epam.microservicesmessagingconsumer.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.epam.microservicesmessagingconsumer.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
