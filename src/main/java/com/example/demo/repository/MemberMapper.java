package com.example.demo.repository;

import com.example.demo.domain.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MemberMapper {

    // 1. init member(ADMIN,USER) insert            // insertMember
    // 2. member 회원 가입시 insert
    Member insertMember(Member member);

    // 6. 회원 가입시 중복 id 검사를 위해 selectById    // selectById
    Member selectMemberById(String id);

    // 5. member list 받으려 selectAll               // selectAll
    List<Member> selectAll();

    // 4. member 삭제시 delete                       // deleteMember
    void deleteMember(Member member);

    // 3. member 승급시 update                       // updateMember
    int promptMember(Member member);
}
