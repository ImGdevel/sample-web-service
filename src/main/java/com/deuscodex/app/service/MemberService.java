package com.deuscodex.app.service;

import com.deuscodex.app.entity.Member;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface  MemberService {

    List<Member> getAllMembers();

    Member getMemberById(Long memberId);

    Member createMember(Member member);

    Member updateMember(Long memberId, Member updatedMember);

    void deleteMember(Long memberId);
}
