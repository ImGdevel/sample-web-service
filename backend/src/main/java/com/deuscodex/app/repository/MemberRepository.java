package com.deuscodex.app.repository;

import com.deuscodex.app.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
