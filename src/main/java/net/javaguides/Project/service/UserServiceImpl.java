package net.javaguides.Project.service;


import net.javaguides.Project.model.Role;
import net.javaguides.Project.model.User;
import net.javaguides.Project.repository.UserRepository;
import net.javaguides.Project.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserRegistrationDto registrationDto){
        User user = new User(registrationDto.getFirstName(),
                registrationDto.getLastName(),registrationDto.getEmail(),
                registrationDto.getPassword(), Arrays.asList(new Role("ROLE_USER")));

        return userRepository.save(user);
    }
    @Override
    public List<User> getUserByEmailPassword(String email, String password){
        return userRepository.getUserByEmailPassword(email, password);
    }
}
