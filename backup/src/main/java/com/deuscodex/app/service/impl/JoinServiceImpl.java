package com.deuscodex.app.service.impl;

import com.deuscodex.app.domain.Member;
import com.deuscodex.app.dto.JoinDTO;
import com.deuscodex.app.dto.MemberDTO;
import com.deuscodex.app.mapper.MemberMapper;
import com.deuscodex.app.repository.MemberRepository;
import com.deuscodex.app.service.JoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoinServiceImpl implements JoinService {
    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public JoinServiceImpl(MemberRepository memberRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.memberRepository = memberRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public MemberDTO createAccount(JoinDTO joinDTO){


        boolean isExist = memberRepository.existsByUsername(joinDTO.getUsername());
        if(isExist){

            return null;
        }


        Member member =
                Member.builder()
                .username(joinDTO.getUsername())
                .password(bCryptPasswordEncoder.encode(joinDTO.getPassword()))
                .email(joinDTO.getEmail())
                .role("ADMIN")
                        .build();

        Member savedMember = memberRepository.save(member);
        return MemberMapper.toDTO(savedMember);
    }
}
