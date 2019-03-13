package com.galaxy.traffic.accident.service;

import com.galaxy.traffic.accident.model.RegionLevel;
import com.galaxy.traffic.accident.model.RoadType;
import com.galaxy.traffic.accident.repository.RoadTypeAccidentRatioRepository;
import com.galaxy.traffic.accident.model.RoadTypeAccidentRatio;
import com.galaxy.traffic.geography.RegionService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zwli
 * @create 2019-01-27 22:45
 */
@Service
public class RoadTypeAccidentRatioService {
    private RoadTypeAccidentRatioRepository roadTypeAccidentRatioRepository;
    private RegionService regionService;

    public RoadTypeAccidentRatioService(RoadTypeAccidentRatioRepository roadTypeAccidentRatioRepository, RegionService regionService) {
        this.roadTypeAccidentRatioRepository = roadTypeAccidentRatioRepository;
        this.regionService = regionService;
    }

    public RoadTypeAccidentRatio getRoadTypeAccidentRatio(Long regionId, Long from, Long to) {
        Timestamp startTime = new Timestamp(from*1000);
        Timestamp endTime= new Timestamp(to*1000);
        List<RoadTypeAccidentRatio.RoadTypeAccidentRatioEntity> listMatchEntity = new ArrayList<RoadTypeAccidentRatio.RoadTypeAccidentRatioEntity>();
        RoadTypeAccidentRatio roadTypeAccidentRatio = null;
        RegionLevel level = regionService.getRegionLevel(regionId);
        switch (level) {
            case PROVINCE:
                listMatchEntity = roadTypeAccidentRatioRepository.findByRegionIdBetweenAndOccurTimeBetween(regionId, regionId + 10000, startTime, endTime);
                break;
            case CITY:
                //listMatchEntity = roadTypeAccidentRatioRepository.findByRegionIdBetweenAndOccurTimeBetween(regionId,regionId+100,startTime,endTime);
                break;
            case COUNTY:
                listMatchEntity = roadTypeAccidentRatioRepository.findByRegionIdAndOccurTimeBetween(regionId, startTime, endTime);
                break;
            default:
                break;
        }
        int sum = listMatchEntity.size();
        float d1 = (float)listMatchEntity.stream().filter(f->f.getRoadType() == RoadType.highway).collect(Collectors.toList()).size()/sum;
        float d2 = (float)listMatchEntity.stream().filter(f->f.getRoadType() == RoadType.provincial).collect(Collectors.toList()).size()/sum;
        return null;
    }

    /*public RoadTypeAccidentRatio getRoadTypeAccidentRatio(Long province, Long from, Long to) {
        return null;
    }*/

    public RoadTypeAccidentRatio getRoadTypeAccidentRatio(Long province, Long city, Long from, Long to) {
        return null;
    }

    public RoadTypeAccidentRatio getRoadTypeAccidentRatio(Long province, Long city, Long district, Long from, Long to) {
        return null;
    }

    public List<RoadTypeAccidentRatio> getAllRoadTypeAccidentRatioListByDistricts(List<Long> districtIds, Long from, Long to) {
        return null;
    }

    public List<RoadTypeAccidentRatio> getAllRoadTypeAccidentRatioListByCities(List<Long> cityIds, Long from, Long to) {
        return null;
    }
}
