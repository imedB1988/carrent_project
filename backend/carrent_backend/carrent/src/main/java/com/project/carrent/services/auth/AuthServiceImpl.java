package com.project.carrent.services.auth;

import org.springframework.stereotype.Service;

import com.project.carrent.dto.SignupRequest;
import com.project.carrent.dto.UserDto;
import com.project.carrent.entity.User;
import com.project.carrent.enums.UserRole;
import com.project.carrent.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

private final UserRepository userRepository;

@Override
public UserDto createCustomer(SignupRequest signupRequest) {
    User user = new User();
    user.setName(signupRequest.getName());
    user.setEmail(signupRequest.getEmail());
    user.setPassword(signupRequest.getPassword());
    user.setUserRole(UserRole.CUSTOMER);
    User createdUser = userRepository.save(user);
    UserDto dto = new UserDto();
    dto.setId(createdUser.getId());
    return dto;

}

@Override
public boolean hasCustomerWithEmail(String email) {
   return userRepository.findFirstByEmail(email).isPresent();
}

}
