package com.example.demo.Service;


import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;

import java.util.List;

public class memberService {
    private final MemberRepository memberRepository;

    public memberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member) {
        checkDuplicateId(member);
        memberRepository.save(member);
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
