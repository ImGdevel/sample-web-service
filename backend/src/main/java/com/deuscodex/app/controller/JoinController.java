package com.deuscodex.app.controller;


import com.deuscodex.app.dto.JoinDTO;
import com.deuscodex.app.dto.MemberDTO;
import com.deuscodex.app.service.JoinService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/join")
public class JoinController {

    @Autowired
    private JoinService joinService;

    @PostMapping
    public ResponseEntity<MemberDTO> joinProcess(@Valid @RequestBody JoinDTO joinDTO){

        MemberDTO createdMember = joinService.createAccount(joinDTO);
        return new ResponseEntity<>(createdMember, HttpStatus.CREATED);
    }
}
