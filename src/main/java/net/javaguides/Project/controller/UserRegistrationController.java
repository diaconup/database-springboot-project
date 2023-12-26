package net.javaguides.Project.controller;

import net.javaguides.Project.model.User;
import net.javaguides.Project.service.UserService;
import net.javaguides.Project.web.dto.UserRegistrationDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserRegistrationController {
    private UserService userService;

    public UserRegistrationController(UserService userService){
        super();
        this.userService = userService;
    }
    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto(){
        return new UserRegistrationDto();
    }
    @GetMapping
    public String showRegistrationForm(){
        return "registration";
    }
    @PostMapping
    public String registerUserAccount(@ModelAttribute("user")UserRegistrationDto registrationDto){
        userService.save(registrationDto);
        return "redirect:/loginPage";
    }

    @GetMapping("/loginPage")
    public String loginUser(@ModelAttribute("user") UserRegistrationDto registrationDto){
        return "loginPage";
    }

    @GetMapping("/invalidUser")
    public String invalidUser(@ModelAttribute("user") UserRegistrationDto registrationDto){
        return "invalidUser";
    }
    @PostMapping("/loginUser")
    public String userLogin(@ModelAttribute("user") UserRegistrationDto registrationDto){
        List<User> existingUser = userService.getUserByEmailPassword(registrationDto.getEmail(),registrationDto.getPassword());

        if(!existingUser.isEmpty())
            return "redirect:/home";
        else
            return "redirect:/invalidUser";
    }
}
