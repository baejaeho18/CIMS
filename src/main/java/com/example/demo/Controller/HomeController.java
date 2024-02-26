package com.example.demo.Controller;

import com.example.demo.Service.CCTVService;
import com.example.demo.domain.CCTV;
import com.example.demo.domain.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class HomeController {
    @Autowired
    private CCTVService cctvService;
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/home")
    public String home(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        Logger log = null;  // 없으면 잘 작동하는데, 에러로 뜸. 있으면 에러메시지는 안뜨는데 작동을 안함. ㅋㅋ뭐지..?
        logger.info("login-id: "+authentication.getName());
        authentication.getAuthorities().forEach((grantedAuthority -> logger.info("auth: "+grantedAuthority.getAuthority())));

        // todo: cctv 정보들
        List<CCTV> cctvs = cctvService.getAllCCTV(); // memberService.findMembers() 를 list 형식으로 저장
        model.addAttribute("cctvs", cctvs);

        // JavaScript 배열에 CCTV 위치 정보 추가
//        StringBuilder positions = new StringBuilder("[");
//        for (CCTV cctv : cctvs) {
//            positions.append("{");
//            positions.append("title: '").append(cctv.getName()).append("', ");
//            positions.append("latlng: new kakao.maps.LatLng(").append(cctv.getXCoordinate()).append(", ").append(cctv.getYCoordinate()).append(")");
//            positions.append("}, ");
//        }
//        positions.append("]");
//        model.addAttribute("positions", positions.toString());

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
}
