package com.deuscodex.app.service.impl;

import com.deuscodex.app.domain.Member;
import com.deuscodex.app.dto.CustomUserDetails;
import com.deuscodex.app.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Autowired
    public CustomUserDetailsService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Member memberData = memberRepository.findByUsername(username);

        if(memberData != null){

            return new CustomUserDetails(memberData);
        }

        return null;
    }
}
