package com.deuscodex.app.service.impl;

import com.deuscodex.app.dto.MemberDTO;
import com.deuscodex.app.domain.Member;
import com.deuscodex.app.mapper.MemberMapper;
import com.deuscodex.app.repository.MemberRepository;
import com.deuscodex.app.service.MemberService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public MemberDTO getMemberById(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new EntityNotFoundException("Member not found with id: " + memberId));
        return MemberMapper.toDTO(member);
    }

    @Override
    public List<MemberDTO> getAllMembers() {
        List<Member> members = memberRepository.findAll();
        return members.stream()
                .map(MemberMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public MemberDTO createMember(MemberDTO memberDTO) {
        Member member = MemberMapper.toEntity(memberDTO);
        Member savedMember = memberRepository.save(member);
        return MemberMapper.toDTO(savedMember);
    }

    @Override
    @Transactional
    public MemberDTO updateMember(Long memberId, MemberDTO memberDTO) {
        Member existingMember = memberRepository.findById(memberId)
                .orElseThrow(() -> new EntityNotFoundException("Member not found with id: " + memberId));

        existingMember.setUsername(memberDTO.getUsername());
        existingMember.setPassword(memberDTO.getPassword());
        existingMember.setEmail(memberDTO.getEmail());

        Member updatedMember = memberRepository.save(existingMember);
        return MemberMapper.toDTO(updatedMember);
    }

    @Override
    @Transactional
    public boolean deleteMember(Long memberId) {
        if (memberRepository.existsById(memberId)) {
            memberRepository.deleteById(memberId);
            return true;
        } else {
            return false;
        }
    }
}
