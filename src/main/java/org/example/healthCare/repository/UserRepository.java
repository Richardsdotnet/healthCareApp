package org.example.healthCare.repository;

import org.example.healthCare.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

}

