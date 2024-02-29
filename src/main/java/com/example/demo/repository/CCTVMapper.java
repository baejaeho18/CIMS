package com.example.demo.repository;

import com.example.demo.domain.CCTV;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CCTVMapper {

    // 1. CCTV search 해서 insert 하기  | 혹은 추가 버튼으로 CCTV 노드 추가?    // insertCCTV
    int insertCCTV(CCTV cctv);

    // 2. CCTV list를 selectAll해서 (marker/video) 띄위기                   // selectAll
    List<CCTV> getCCTV();

    // 3. CCTV meta data 받아와서 info update 하기                          // updateCCTVInfoFromNode
    int updateCCTVStatusFromNode(CCTV cctv);

    // 4. 각 CCTV마다 meta data select해서 띄우기(infobox)                   // selectCCTVStatusByName
    // 띄울 정보 : signal_strength, camera_valid, emergency
    CCTV selectCCTVStatusByName(String name);


    // 5. 가능하다면, 마커를 이동시켜서 CCTV 노드 위치 update                   // updateCCTVLocation
    int updateCoordinates(CCTV cctv);   // for test

    // 6. 가능하다면, 마커의 이름도 바꿀 수 있게                                // updateCCTVName
    int updateCCTVName(CCTV cctv);

    // 7. 가능하다면, CCTV노드 제거 기능도                                    // deleteCCTV
    int deleteCCTV(int id);
}
