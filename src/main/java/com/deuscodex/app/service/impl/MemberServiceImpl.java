package com.deuscodex.app.service.impl;

import com.deuscodex.app.entity.Member;
import com.deuscodex.app.repository.MemberRepository;
import com.deuscodex.app.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Member getMemberById(Long memberId) {
        Optional<Member> optionalMember = memberRepository.findById(memberId);
        return optionalMember.orElse(null);
    }

    @Override
    public Member createMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Member updateMember(Long memberId, Member updatedMember) {
        Optional<Member> optionalMember = memberRepository.findById(memberId);
        if (optionalMember.isPresent()) {
            Member existingMember = optionalMember.get();
            // 업데이트 로직을 추가할 수 있습니다.
            return memberRepository.save(existingMember);
        }
        return null; // 혹은 적절한 예외를 던질 수 있습니다.
    }

    @Override
    public void deleteMember(Long memberId) {
        memberRepository.deleteById(memberId);
    }
}
