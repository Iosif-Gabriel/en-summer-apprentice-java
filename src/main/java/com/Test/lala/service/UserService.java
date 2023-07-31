package com.Test.lala.service;

import com.Test.lala.model.OrderU;
import com.Test.lala.model.UserU;
import com.Test.lala.repository.UserRepository;
import com.Test.lala.service.interfaceservice.IUserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserU findUserById(Long id){
        Optional<UserU> userFindById=userRepository.findById(id);
        if(userFindById.isPresent()){
            return userFindById.get();
        }
        else{
            throw new EntityNotFoundException("Event not found "+userFindById);
        }
    }
}
