package com.example.demo.Controller;

import com.example.demo.Service.MemberService;
import com.example.demo.domain.Member;
import com.example.demo.domain.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;

public class MemberController {
    @Autowired
    private MemberService memberService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public String signup(MemberDto memberDto) {
        // 회원가입
        Member member = new Member();
        member.setId(memberDto.getId());
        member.setPwd(passwordEncoder.encode(memberDto.getPwd()));
        member.setName(memberDto.getName());
//        member.setAuth(memberDto.getRole());      // 차후 admin 계정에서만 admin 권한 줄 수 있고 default로 user 권한
        memberService.join(member); // service 에서 duplicate 검사 후 실제로 repository에 저장

        // 자동 로그인
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
                member.getId(), memberDto.getPwd());
        Authentication authentication = authenticationManager.authenticate(authRequest);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return "redirect:/home";
    }
}
