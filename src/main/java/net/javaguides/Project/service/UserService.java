package net.javaguides.Project.service;


import net.javaguides.Project.model.User;
import net.javaguides.Project.web.dto.UserRegistrationDto;

import java.util.List;

public interface UserService {
    User save(UserRegistrationDto registrationDto);
    List<User> getUserByEmailPassword(String email, String password);
}
