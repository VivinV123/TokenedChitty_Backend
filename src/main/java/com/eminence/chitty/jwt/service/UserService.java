package com.eminence.chitty.jwt.service;

import com.eminence.chitty.jwt.dto.UserRegistrationDTO;
import com.eminence.chitty.jwt.entity.UserRegistration;
import org.springframework.stereotype.Service;
//import com.experion.mainbackend.dto.UserRegistrationDTO;
//import com.experion.mainbackend.entity.UserRegistration;


public interface UserService {

    UserRegistration registerNewUserAccount(UserRegistrationDTO userRegistrationDTO);
}
