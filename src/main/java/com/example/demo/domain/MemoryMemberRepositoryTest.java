//package com.example.demo.domain;
//
//import com.example.demo.repository.MemoryMemberRepository;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.*;
//
//class MomoryMemberRepositoryTest {
//
//    MemoryMemberRepository repository = new MemoryMemberRepository();
//
//    @AfterEach // 하나의 메서드가 끝나면 AfterEach 메서드 동작
//    public void AfterEach(){
//        repository.clearStore();
//    }
//
//    @Test
//    public void save(){
//        Member member = new Member();
////        Member member2 = new Member();
//
//        member.setName("java");
////        member2.setName("하늘");
//
//        repository.save(member);
////        repository.save(member2);
//
////        System.out.println(member.getCode());
////        System.out.println(member.getName());
//
//        Member result = repository.findByCode(member.getCode()).get();
//        //  repository 안에 저장된 memeberCode 를 가져와서 result 에 저장
//
//        // 기대값과 실제값을 확인하기 위해 Assertions 의 assertEquals 라는 메서드 활용
//
//        // 검증 방법 1. Assertions.assertEquals(기대값, 실제값) => junit
////        Assertions.assertEquals(member, result);
//
//        // 검증 방법 2. Assertions.assertThat(실제값).isEqualTo(기대값) => assertj
//        assertThat(result).isEqualTo(member); // static import 상태
//
//        System.out.println("저장되는 값이 확인되었습니다.");
//
//    }
//
//    @Test
//    public void findByName(){
//        Member member1 = new Member();
//        member1.setName("pray");
//        repository.save(member1);
//
//        Member member2 = new Member();
//        member2.setName("Anne");
//        repository.save(member2);
//
//        Member result = repository.findByName("pray").get();
//
//        assertThat(result).isEqualTo(member1);
////        System.out.println(member1.getCode() + " " + member1.getName());
//
//        System.out.println("findByName 정상 동작 확인하였습니다");
//
//    }
//
/////// 여기서부터 //////
//
//    @Test
//    public void findById(){ // findById 메소드 동작 테스트
//        Member member = new Member();
//        member.setId("java_ID");
//
//        repository.save(member);
//
//        Member findId = repository.findById("java_ID").get();
//
//        assertThat(findId).isEqualTo(member);
//
//        System.out.println(member.getId());
//        System.out.println("findById 정상 동작 확인");
//
//    }
//
//    @Test
//    public void findByPasswd(){ // findByPasswd 메소드 동작 테스트
//        Member member = new Member();
//        member.setPasswd("java_passWD");
//
//        repository.save(member);
//
//        Member findPW = repository.findByPasswd("java_passWD").get();
//
//        assertThat(findPW).isEqualTo(member); // 여기서 member 은 내가 방금 저장한 member
//
//        System.out.println(member.getPasswd());
//        System.out.println("findByPasswd 정상 작동 확인");
//
//    }
//
/////// 여기까지 추가 //////
//
//
//    @Test
//    public void findAll(){
//        Member memeber1 = new Member();
//
//        Member member1 = new Member();
//        member1.setName("pray");
//        repository.save(member1);
//
//        Member member2 = new Member();
//        member2.setName("Anne");
//        repository.save(member2);
//
//        List<Member> result = repository.findAll();
//
//        assertThat(result.size()).isEqualTo(2);
//
//        System.out.println("findAll 정상 동작 확인하였습니다");
//
//    }
//}
//출처: https://terianp.tistory.com/49 [Terian의 IT 도전기:티스토리]