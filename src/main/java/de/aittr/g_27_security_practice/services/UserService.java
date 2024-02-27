package de.aittr.g_27_security_practice.services;

import de.aittr.g_27_security_practice.domain.Role;
import de.aittr.g_27_security_practice.domain.User;
import de.aittr.g_27_security_practice.domain.dto.RoleDto;
import de.aittr.g_27_security_practice.domain.dto.UserDto;
import de.aittr.g_27_security_practice.domain.dto.UserRegistrationDto;
import de.aittr.g_27_security_practice.repositories.UserRepository;
import de.aittr.g_27_security_practice.services.mapping.UserMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {
    private UserRepository repository;
    private UserMappingService service;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository repository, UserMappingService service) {
        this.repository = repository;
        this.service = service;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }

    public UserDto registration(UserRegistrationDto registrationDto) {
        User entity = service.mapRegistrationDtoToEntity(registrationDto);
        entity.setId(0);
        entity.getRoles().add(new Role("USER"));
        entity.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        entity = repository.save(entity);
        return service.mapEntityToDto(entity);
    }
}