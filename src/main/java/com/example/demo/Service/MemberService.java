package com.example.demo.Service;


import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private static final Logger logger = LoggerFactory.getLogger(MemberService.class);


    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member) {
        checkDuplicateId(member);
        // duplicate check 후
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

    public void printMembers(List<Member> members) {
        logger.info("memberList:");
        for (Member member : members) {
            logger.info("Name: {}, ID: {}, PWD: {}", member.getName(), member.getId(), member.getPwd());
        }
    }

}
