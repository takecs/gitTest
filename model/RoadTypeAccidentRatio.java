package com.galaxy.traffic.accident.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.sql.Timestamp;

public class RoadTypeAccidentRatio{


    @Data
    @Entity
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Table(name = "accident")
    public static class RoadTypeAccidentRatioEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false)

        private long id;//事故唯一标示id

        @Column(name = "sgfssj")
        private Timestamp occurTime;//事故发生时间
        @Column(name = "xzqh")
        private long regionId;//区域编码
        @Column(name = "dllx")
        private RoadType roadType;//道路级别
    }
}

