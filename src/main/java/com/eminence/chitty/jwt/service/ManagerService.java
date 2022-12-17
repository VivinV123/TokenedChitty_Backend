package com.eminence.chitty.jwt.service;

import com.eminence.chitty.jwt.dao.ManagerRepo;
import com.eminence.chitty.jwt.entity.Manager;
import com.eminence.chitty.jwt.helper.Helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ManagerService {

    @Autowired
    private ManagerRepo managerRepo;

    public void save(MultipartFile file) {

        try {
            List<Manager> managers = Helper.convertExcelToListOfManager(file.getInputStream());
            this.managerRepo.saveAll(managers);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<Manager> getAllManagers(){
        return (List<Manager>)managerRepo.findAll();
    }

//    public List<Manager> getAllManagers() {
//        return this.managerRepo.findAll();
//    }
//
    public void add(Manager manager){
        this.managerRepo.save(manager);
    }


}
