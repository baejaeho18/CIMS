package com.example.demo.Controller;

import com.example.demo.Service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Slf4j
@RequiredArgsConstructor
@Controller
public class HomeController {
    private final MemberService memberService;
    @GetMapping("/home")
    public String home() {
//        memberService.findMembers().forEach((member -> log.info(member.toString())));
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info(authentication.getName());
        authentication.getAuthorities().stream().forEach((grantedAuthority -> log.info(grantedAuthority.getAuthority())));

        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @GetMapping("/logout")
    public String logout() {
        return "logout";
    }

    @GetMapping("/memberList")
    public String memberList() {
        return "memberList";
    }
}
