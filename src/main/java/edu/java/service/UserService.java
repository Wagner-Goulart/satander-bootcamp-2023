package edu.java.service;

import edu.java.domain.model.User;

public interface UserService {
    User findById(Long Id);

    User create(User userToCreate);
}
