package com.deuscodex.app.service.impl;

import com.deuscodex.app.dto.MemberDTO;
import com.deuscodex.app.entity.Member;
import com.deuscodex.app.mapper.MemberMapper;
import com.deuscodex.app.repository.MemberRepository;
import com.deuscodex.app.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberServiceImpl implements MemberService {

  @Autowired
    private MemberRepository memberRepository;

    public MemberDTO getMemberById(Long memberId) {
        Member member = memberRepository.findById(memberId).orElse(null);
        return MemberMapper.toDTO(member); // 엔터티를 DTO로 변환
    }

    public List<MemberDTO> getAllMembers() {
        List<Member> members = memberRepository.findAll();
        return members.stream()
                .map(MemberMapper::toDTO) // 각 엔터티를 DTO로 변환
                .collect(Collectors.toList());
    }

    public MemberDTO createMember(MemberDTO memberDTO) {
        Member member = MemberMapper.toEntity(memberDTO); // DTO를 엔터티로 변환
        // 비즈니스 로직 수행 후 저장
        Member savedMember = memberRepository.save(member);
        return MemberMapper.toDTO(savedMember); // 엔터티를 DTO로 변환하여 반환
    }

    public MemberDTO updateMember(Long memberId, MemberDTO memberDTO) {
        Member existingMember = memberRepository.findById(memberId).orElse(null);

        if (existingMember != null) {
            existingMember.setName(memberDTO.getName());
            existingMember.setUsername(memberDTO.getUsername());
            existingMember.setPassword(memberDTO.getPassword());
            existingMember.setEmail(memberDTO.getEmail());
            existingMember.setPhoneNumber(memberDTO.getPhoneNumber());

            // 비즈니스 로직 수행 후 저장
            Member updatedMember = memberRepository.save(existingMember);
            return MemberMapper.toDTO(updatedMember); // 엔터티를 DTO로 변환하여 반환
        } else {
            return null;
        }
    }

    public boolean deleteMember(Long memberId) {
        if (memberRepository.existsById(memberId)) {
            memberRepository.deleteById(memberId);
            return true;
        } else {
            return false;
        }
    }
}
