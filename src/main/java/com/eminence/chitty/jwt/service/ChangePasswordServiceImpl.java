package com.eminence.chitty.jwt.service;

import com.eminence.chitty.jwt.dao.ManagerRepo;
import com.eminence.chitty.jwt.dao.UserLoginRepo;
import com.eminence.chitty.jwt.dao.UserRegistrationRepo;
import com.eminence.chitty.jwt.dto.ChangePassword;
import com.eminence.chitty.jwt.entity.Manager;
import com.eminence.chitty.jwt.entity.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Service
public class ChangePasswordServiceImpl implements ChangePasswordService{
    @Autowired
    private UserLoginRepo userLoginRepo;
    @Autowired
    private UserRegistrationRepo userRegistrationRepo;

    @Autowired
    private ManagerRepo managerRepo;
    @Override
    public String changePassword(ChangePassword changePassword) {
        BCryptPasswordEncoder bcrypt=new BCryptPasswordEncoder();
        String encryptedPassword= bcrypt.encode(changePassword.getNewPassword());
        List<UserLogin> login=userLoginRepo.findAll();

        for(UserLogin userLogin:login){
            if (Objects.equals(userLogin.getEmail(), changePassword.getEmail())&& (bcrypt.matches(changePassword.getCurrentPassword(),userLogin.getPassword()))) {
                userLogin.setPassword(encryptedPassword);
                Manager manager = managerRepo.findById(userLogin.getUserId()).get();
                manager.setPassWord(encryptedPassword);
                managerRepo.save(manager);
                userLoginRepo.save(userLogin);
                return "Password updated successfully!";
            }
        }

        return "User not found!";
    }
}
