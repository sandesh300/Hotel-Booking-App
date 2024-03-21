package com.hotelbooking.service;

import com.hotelbooking.exception.UserAlreadyExistsException;
import com.hotelbooking.model.Role;
import com.hotelbooking.model.User;
import com.hotelbooking.repository.RoleRepository;
import com.hotelbooking.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService{

private final UserRepository userRepository;
private final PasswordEncoder passwordEncoder;
private final RoleRepository roleRepository;
    @Override
    public User registerUser(User user) {
        if(userRepository.existByEmail(user.getEmail())){
         throw  new UserAlreadyExistsException(user.getEmail() + "already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role userRole= roleRepository.findByName("ROLE_USER").get();
        user.setRoles(Collections.singletonList(userRole));
        return userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Transactional
    @Override
    public void deleteUser(String email) {
        User theUser = getUser(email);
        if (theUser != null){
            userRepository.deleteByEmail(email);
        }

    }


    @Override
    public User getUser(String email) {
        return userRepository.findByEmail(email)
                    .orElseThrow(()->new UsernameNotFoundException("User Not Found"));
    }
}
