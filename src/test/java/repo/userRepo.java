package repo;

import org.example.healthCare.models.User;
import org.example.healthCare.repository.HealthCareUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class userRepo {
    HealthCareUserRepository repository;

    @BeforeEach
    void setUp(){
        repository = new HealthCareUserRepository();
    }

    @Test
    void testSave(){
        User user = new User();
        repository.save(user);
        assertEquals(1, repository.length());
        User userTwo = new User();
        repository.save(userTwo);
        assertEquals(2, repository.length());
    }
}
