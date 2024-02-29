package com.example.demo.Controller;

import com.example.demo.Service.MemberService;
import com.example.demo.domain.Member;
import com.example.demo.domain.MemberForm;
import com.example.demo.domain.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MemberController {
    @Autowired
    private MemberService memberService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public String signup(MemberForm memberForm) {
//        memberService.join(new Member("user", "user", "password"));
//        memberService.join(new Member("admin", "admin", "password", UserRole.ADMIN));

        // 회원가입
        Member member = new Member();
        member.setId(memberForm.getId());
        member.setPwd(passwordEncoder.encode(memberForm.getPwd()));
        member.setName(memberForm.getName());
        member.setUserRole(UserRole.ROLE_USER);      // 차후 admin 계정에서만 admin 권한 줄 수 있고 default로 user 권한
        memberService.join(member); // service 에서 duplicate 검사 후 실제로 repository에 저장

        // 자동 로그인
//        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
//                member.getId(), memberDto.getPwd());
//        Authentication authentication = authenticationManager.authenticate(authRequest);
//        SecurityContextHolder.getContext().setAuthentication(authentication);

        memberService.printMembers(memberService.findMembers());
        return "redirect:/login";
    }

    @GetMapping("/memberList") // members 페이지에 대해 Get 으로 넘어올 때 -> 주로 값을 불러오는 하는 경우
    public String getMemberList(Model model) { // Model 사용을 list 로 사용
        List<Member> members = memberService.findMembers(); // memberService.findMembers() 를 list 형식으로 저장
        model.addAttribute("members", members);
        // 파라미터로 넘어온 members 을 model에 담아서 members/members_list 의 members 로 넘긴다.
        return "memberList"; // return 시에는 앞에  " / " 가 없어야함
    }

    @PostMapping("/delete")
    public String deleteMember(@RequestParam("id") String memberId) {
        // memberId를 사용하여 회원 삭제 작업을 수행
        memberService.deleteMemberById(memberId);
        return "redirect:/memberList"; // 회원 목록 페이지로 리다이렉트
    }

    @PostMapping("/promote")
    public String promoteMember(@RequestParam("id") String memberId) {
        // memberId를 사용하여 회원의 권한을 승급하는 작업을 수행
        memberService.promoteMemberToAdmin(memberId);
        return "redirect:/memberList"; // 회원 목록 페이지로 리다이렉트
    }
}
