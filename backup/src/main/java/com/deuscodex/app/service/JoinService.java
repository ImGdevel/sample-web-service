package com.deuscodex.app.service;

import com.deuscodex.app.dto.JoinDTO;
import com.deuscodex.app.dto.MemberDTO;
import org.springframework.stereotype.Service;

@Service
public interface JoinService {
    MemberDTO createAccount(JoinDTO joinDTO);

}
