package com.example.demo.repository;

import com.example.demo.domain.CCTV;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CCTVMapper {
    List<CCTV> getCCTV();

    int insertCCTV(CCTV cctv);

    int updateCoordinate(CCTV cctv);

    int updateCCTVName(CCTV cctv);

    int updateCCTVStatus(CCTV cctv);

    int deleteCCTV(int id);

}
