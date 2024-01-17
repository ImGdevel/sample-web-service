package com.deuscodex.app.mapper;

import com.deuscodex.app.dto.MemberDTO;
import com.deuscodex.app.entity.Member;

public class MemberMapper {

    // MemberDTO -> Member 엔터티로 변환
    public static Member toEntity(MemberDTO memberDTO) {
        return Member.builder()
                .memberId(memberDTO.getMemberId())
                .name(memberDTO.getName())
                .username(memberDTO.getUsername())
                .password(memberDTO.getPassword())
                .email(memberDTO.getEmail())
                .phoneNumber(memberDTO.getPhoneNumber())
                .build();
    }

    // Member 엔터티 -> MemberDTO로 변환
    public static MemberDTO toDTO(Member member) {
        return MemberDTO.builder()
                .memberId(member.getMemberId())
                .name(member.getName())
                .username(member.getUsername())
                .password(member.getPassword())
                .email(member.getEmail())
                .phoneNumber(member.getPhoneNumber())
                .build();
    }
}
