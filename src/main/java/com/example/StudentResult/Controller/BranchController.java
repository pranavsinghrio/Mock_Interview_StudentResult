package com.example.StudentResult.Controller;
import com.example.StudentResult.*;
import com.example.StudentResult.Dto.BranchRequestDto;
import com.example.StudentResult.Service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/branch")
public class BranchController {

    @Autowired
    BranchService branchService;

    @PostMapping("/add")
    public ResponseEntity<String> addStudent(@RequestBody BranchRequestDto branchRequestDto){
        branchService.addBranch(branchRequestDto);
        return new ResponseEntity<>("Success", HttpStatus.ACCEPTED);
    }

    @GetMapping("/get_contactNo")
    public ResponseEntity<List<String>> getHodContacts(){
        List<String> result=branchService.getHodContact();

        return new ResponseEntity<>(result,HttpStatus.FOUND);
    }




}