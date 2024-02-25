package com.example.demo.Controller;

import com.example.demo.domain.CCTV;
import com.example.demo.Service.CCTVService;
import com.example.demo.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CCTVController {
    @Autowired
    private CCTVService cctvService;

    @GetMapping("/api/cctv")
    public List<CCTV> getALLCCTV() {
        return cctvService.getAllCCTV();
    }
}
