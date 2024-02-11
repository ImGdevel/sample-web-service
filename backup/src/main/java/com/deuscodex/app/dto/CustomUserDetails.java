package com.deuscodex.app.dto;

import com.deuscodex.app.domain.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collection;


public class CustomUserDetails implements UserDetails {


    private Member member;

    public CustomUserDetails(Member member){
        this.member = member;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection<GrantedAuthority> collection = new ArrayList<>();

        collection.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return member.getRole();
            }
        });



        return null;
    }

    @Override
    public String getPassword() {
        return member.getPassword();
    }

    @Override
    public String getUsername() {
        return getUsername();
    }

    //계정 만료
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //계정 잠김
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //존재
    @Override
    public boolean isEnabled() {
        return true;
    }
}
