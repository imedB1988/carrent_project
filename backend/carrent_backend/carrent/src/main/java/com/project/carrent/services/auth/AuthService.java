package com.project.carrent.services.auth;



import com.project.carrent.dto.SignupRequest;
import com.project.carrent.dto.UserDto;

public interface AuthService {

    UserDto createCustomer(SignupRequest signupRequest);
    boolean hasCustomerWithEmail(String email);

}
