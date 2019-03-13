package com.galaxy.traffic.accident.repository;

import com.galaxy.traffic.accident.model.RoadTypeAccidentRatio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public interface RoadTypeAccidentRatioRepository extends CrudRepository<RoadTypeAccidentRatio.RoadTypeAccidentRatioEntity, Long> {
    List<RoadTypeAccidentRatio.RoadTypeAccidentRatioEntity> findByRegionIdBetweenAndOccurTimeBetween(Long startRegionId, long endRegionId, Timestamp startTime, Timestamp endTime);
    List<RoadTypeAccidentRatio.RoadTypeAccidentRatioEntity> findByRegionIdAndOccurTimeBetween(Long startRegionId,Timestamp startTime, Timestamp endTime);
    List<RoadTypeAccidentRatio.RoadTypeAccidentRatioEntity> findByOccurTimeBetween(@Param("startTime") Timestamp startTime, @Param("endTime") Timestamp endTime);
}
