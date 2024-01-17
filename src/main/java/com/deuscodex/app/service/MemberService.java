package com.deuscodex.app.service;

import com.deuscodex.app.dto.MemberDTO;
import com.deuscodex.app.entity.Member;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface  MemberService {

    List<MemberDTO> getAllMembers();

    MemberDTO getMemberById(Long memberId);

    MemberDTO createMember(MemberDTO member);

    MemberDTO updateMember(Long memberId, MemberDTO updatedMember);

    boolean deleteMember(Long memberId);
}
