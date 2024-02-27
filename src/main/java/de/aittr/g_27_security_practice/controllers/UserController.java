package de.aittr.g_27_security_practice.controllers;

import de.aittr.g_27_security_practice.domain.dto.UserDto;
import de.aittr.g_27_security_practice.domain.dto.UserRegistrationDto;
import de.aittr.g_27_security_practice.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/registration")
    public UserDto registration(@RequestBody UserRegistrationDto registrationDto) {
        return service.registration(registrationDto);
    }
}