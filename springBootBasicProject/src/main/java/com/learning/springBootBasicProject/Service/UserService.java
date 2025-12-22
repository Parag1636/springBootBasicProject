package com.learning.springBootBasicProject.Service;

import com.learning.springBootBasicProject.Entity.EmployeeEntity;
import com.learning.springBootBasicProject.Entity.UserEntity;
import com.learning.springBootBasicProject.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void saveUser(UserEntity userEntity){
        userRepository.save(userEntity);
    }

    public void saveNewUser(UserEntity userEntity){
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userEntity.setRoles(Arrays.asList("User"));
        userRepository.save(userEntity);
    }

    public void deleteById(String myId) {userRepository.deleteById(myId);}

    public Optional<UserEntity> findById(String myId) {
        return userRepository.findById(myId);
    }

    public List<UserEntity> getAllUser() {
       return userRepository.findAll();
    }

    public UserEntity findByName(String name){
        return userRepository.findByName(name);
    }
}
