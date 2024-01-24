package net.openwebinars.springboot.restjwt;

import jakarta.persistence.EntityManager;
import net.openwebinars.springboot.restjwt.user.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    EntityManager em;

    @Autowired
    UserRepository userRepository;

    
}
