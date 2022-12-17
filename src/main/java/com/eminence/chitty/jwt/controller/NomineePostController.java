package com.eminence.chitty.jwt.controller;



import com.eminence.chitty.jwt.dto.NomineePost;
import com.eminence.chitty.jwt.service.NomineeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/nominee")

public class NomineePostController {

    @Autowired
    private NomineeService nomineeService;

    @PostMapping("/add")
    public NomineePost addNominee(@RequestBody NomineePost request){
        return nomineeService.addNominee(request);
    }




}
