package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

@Getter
@Setter
public class CCTV {
    private int id;
    private String name;
    private String videoUrl;
    @Value("${hls.output.location}")
    private String storagePath;
    private double xCoordinate;
    private double yCoordinate;
    private int networkStat;

    public CCTV(int id, String name, double xCoordinate, double yCoordinate, int networkStat) {
        this.id = id;
        this.name = name;
        this.videoUrl = "http://localhost:8080/cctv/pi"+id+"/output.m3u8";
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.networkStat = networkStat;
    }

}
