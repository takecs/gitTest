package com.galaxy.traffic.accident.controller;

import com.galaxy.traffic.accident.service.RoadTypeAccidentRatioService;
import com.galaxy.traffic.accident.model.RoadTypeAccidentRatio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/road-type-accident-ratio", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@CrossOrigin
public class RoadTypeAccidentRatioController {

    private RoadTypeAccidentRatioService roadTypeAccidentRatioService;

    public RoadTypeAccidentRatioController(RoadTypeAccidentRatioService roadTypeAccidentRatioService) {
        this.roadTypeAccidentRatioService = roadTypeAccidentRatioService;
    }

    @GetMapping(value = "/{province}")
    public RoadTypeAccidentRatio getRoadTypeAccidentRatio(@PathVariable("province") Long province,
                                                          @RequestParam("from") Long from,
                                                          @RequestParam("to") Long to) {
        return roadTypeAccidentRatioService.getRoadTypeAccidentRatio(province, from, to);
    }

    @GetMapping(value = "/{province}/{city}")
    public RoadTypeAccidentRatio getRoadTypeAccidentRatio(@PathVariable("province") Long province,
                                                          @PathVariable("city") Long city,
                                                          @RequestParam("from") Long from,
                                                          @RequestParam("to") Long to) {
        return roadTypeAccidentRatioService.getRoadTypeAccidentRatio(province, city, from, to);
    }

    @GetMapping(value = "/{province}/{city}/{district}")
    public RoadTypeAccidentRatio getRoadTypeAccidentRatio(@PathVariable("province") Long province,
                                                          @PathVariable("city") Long city,
                                                          @PathVariable("district") Long district,
                                                          @RequestParam("from") Long from,
                                                          @RequestParam("to") Long to) {
        return roadTypeAccidentRatioService.getRoadTypeAccidentRatio(province, city, district, from, to);
    }

    @PostMapping(value = "/county", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<RoadTypeAccidentRatio> getAllRoadTypeAccidentRatioListByDistricts(@RequestBody List<Long> districtIds,
                                                                                  @RequestParam("from") Long from,
                                                                                  @RequestParam("to") Long to) {
        return roadTypeAccidentRatioService.getAllRoadTypeAccidentRatioListByDistricts(districtIds, from, to);
    }

    @PostMapping(value = "/city", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<RoadTypeAccidentRatio> getAllRoadTypeAccidentRatioListByCities(@RequestBody List<Long> cityIds,
                                                                               @RequestParam("from") Long from,
                                                                               @RequestParam("to") Long to) {
        return roadTypeAccidentRatioService.getAllRoadTypeAccidentRatioListByCities(cityIds, from, to);
    }
}
