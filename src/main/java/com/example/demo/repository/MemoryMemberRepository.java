package com.example.demo.repository;

import com.example.demo.domain.Member;
import org.springframework.stereotype.Repository;

import java.sql.Array;
import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository {
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setHashcode(++sequence);
        store.put(member.getHashcode(), member);
        return member;
    }
    @Override
    public Optional<Member> findByHash(Long hash) {
        return Optional.ofNullable(store.get(hash));
    }
    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }
    @Override
    public Optional<Member> findById(String id) {
        return store.values().stream()
                .filter(member -> member.getId().equals(id))
                .findAny();
    }
    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}
