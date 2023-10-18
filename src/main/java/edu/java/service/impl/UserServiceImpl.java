package edu.java.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import edu.java.domain.model.User;
import edu.java.domain.repository.UserRepository;
import edu.java.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long Id) {
       return userRepository.findById(Id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        
        if(userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())){
            throw new IllegalArgumentException("Essa conta já existe");
        }
        return userRepository.save(userToCreate);
    }
    
}
