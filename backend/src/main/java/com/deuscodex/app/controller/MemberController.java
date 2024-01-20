package com.deuscodex.app.controller;

import com.deuscodex.app.dto.MemberDTO;
import com.deuscodex.app.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/{memberId}")
    public ResponseEntity<?> getMemberById(@PathVariable Long memberId) {
        MemberDTO memberDTO = memberService.getMemberById(memberId);
        return (memberDTO != null) ? ResponseEntity.ok(memberDTO) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<MemberDTO>> getAllMembers() {
        List<MemberDTO> members = memberService.getAllMembers();
        return (members != null && !members.isEmpty()) ? ResponseEntity.ok(members) : ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<MemberDTO> createMember(@Valid @RequestBody MemberDTO memberDTO) {
        MemberDTO createdMember = memberService.createMember(memberDTO);
        return new ResponseEntity<>(createdMember, HttpStatus.CREATED);
    }

    @PutMapping("/{memberId}")
    public ResponseEntity<MemberDTO> updateMember(@PathVariable Long memberId, @Valid @RequestBody MemberDTO memberDTO) {
        MemberDTO updatedMember = memberService.updateMember(memberId, memberDTO);
        return (updatedMember != null) ? ResponseEntity.ok(updatedMember) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<String> deleteMember(@PathVariable Long memberId) {
        boolean deleted = memberService.deleteMember(memberId);
        return (deleted) ? ResponseEntity.ok("Member deleted successfully") : ResponseEntity.notFound().build();
    }
}
