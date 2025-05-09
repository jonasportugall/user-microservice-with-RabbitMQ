package com.microservice.user.services;

import com.microservice.user.entities.User;
import com.microservice.user.producers.UserProducer;
import com.microservice.user.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserProducer userProducer;

    public UserService(UserRepository userRepository, UserProducer userProducer){
        this.userRepository = userRepository;
        this.userProducer = userProducer;
    }

    @Transactional
    public User addUser(User user){
        userRepository.save( user );
        userProducer.publishMessageEmail( user );//para enviar os dados do user na fila da Mensageria
        return user;
    }

}
