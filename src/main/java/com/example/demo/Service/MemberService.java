package com.example.demo.Service;


import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;

import java.util.List;

public class MemberService {
    private final MemberRepository memberRepository;
    private long hashcode;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member) {
        checkDuplicateId(member);
        // duplicate check 후
        memberRepository.save(member);
        member.setHashcode(hashcode++);
        member.setValid(Boolean.TRUE);    // 계정 삭제 시 invalid로 바꾸기
        return member.getHashcode();
    }

    private void checkDuplicateId(Member member) {
        memberRepository.findById(member.getId())
                .ifPresent(m -> {
                    throw new IllegalStateException("This ID already exist");
                });
    }

    public List<Member> findMembers()
    {
        return memberRepository.findAll();
    }

}
