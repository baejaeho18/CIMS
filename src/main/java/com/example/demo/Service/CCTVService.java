package com.example.demo.Service;

import com.example.demo.domain.CCTV;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CCTVService {
    private List<CCTV> cctvList = new ArrayList<>();

    @PostConstruct
    public void init() {
        cctvList.add(new CCTV(1, "cctv1", 36.104359, 129.385868, 3));
        cctvList.add(new CCTV(2, "cctv2", 36.104959, 129.385698, 2));
        cctvList.add(new CCTV(3, "cctv3", 36.104459, 129.386868, 3));
        cctvList.add(new CCTV(4, "cctv4", 36.103359, 129.386668, 1));
    }

    public List<CCTV> getAllCCTV() {
        return cctvList;
    }
}
