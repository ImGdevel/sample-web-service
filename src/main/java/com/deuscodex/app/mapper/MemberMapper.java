package com.deuscodex.app.mapper;

import com.deuscodex.app.dto.MemberDTO;
import com.deuscodex.app.domain.Member;

public class MemberMapper {

    private MemberMapper() {
        // 인스턴스 생성 방지
    }
    public static MemberDTO toDTO(Member member) {
        return MemberDTO.builder()
                .userId(member.getUserId())
                .username(member.getUsername())
                .password(member.getPassword())
                .email(member.getEmail())
                .build();
    }

    public static Member toEntity(MemberDTO memberDTO) {
        return Member.builder()
                .userId(memberDTO.getUserId())
                .username(memberDTO.getUsername())
                .password(memberDTO.getPassword())
                .email(memberDTO.getEmail())
                .build();
    }
}
