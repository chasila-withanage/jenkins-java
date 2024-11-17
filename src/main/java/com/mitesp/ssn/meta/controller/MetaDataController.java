package com.mitesp.ssn.meta.controller;

import com.mitesp.ssn.meta.model.GenericRestModel;
import com.mitesp.ssn.meta.model.MetaDataDTO;
import com.mitesp.ssn.meta.model.ModuleName;
import com.mitesp.ssn.meta.service.CacheService;
import com.mitesp.ssn.meta.service.MetaDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/meta")
@RequiredArgsConstructor
public class MetaDataController {

    private final MetaDataService metaDataService;
    private final CacheService cacheService;

    @GetMapping("/provinces")
    public ResponseEntity<List<MetaDataDTO>> getAllProvinces(@RequestParam(defaultValue = "en") String lang) {
        return ResponseEntity.ok().body(metaDataService.getAllProvincesByLang(lang));
    }

    @GetMapping("/districts")
    public ResponseEntity<List<MetaDataDTO>> getAllDistrictsByLang(@RequestParam(defaultValue = "en") String lang) {
        return ResponseEntity.ok().body(metaDataService.getAllDistrictsByLang(lang));
    }

    @GetMapping("/ds/{districtId}")
    public ResponseEntity<List<MetaDataDTO>> getAllDivSecsByDistrictAndLang(@PathVariable("districtId") Integer district,
                                                                            @RequestParam(defaultValue = "en") String lang) {
        return ResponseEntity.ok().body(metaDataService.getAllDivSecsByDistrictAndLang(district, lang));
    }

    @GetMapping("/gs/{dsId}")
    public ResponseEntity<List<MetaDataDTO>> getAllGsByDsAndLang(@PathVariable("dsId") Integer ds,
                                                                 @RequestParam(defaultValue = "en") String lang) {
        return ResponseEntity.ok().body(metaDataService.getAllGsByDsAndLang(ds, lang));
    }

    @GetMapping("/edu-zones")
    public ResponseEntity<List<MetaDataDTO>> getAllZonesByLang(@RequestParam(defaultValue = "en") String lang) {
        return ResponseEntity.ok().body(metaDataService.getAllZonesByLang(lang));
    }

    @GetMapping("/div-edu-zones/{eduZoneId}")
    public ResponseEntity<List<MetaDataDTO>> getAllDivZonesByZoneAndLang(@PathVariable("eduZoneId") Integer zone,
                                                                         @RequestParam(defaultValue = "en") String lang) {
        return ResponseEntity.ok().body(metaDataService.getAllDivZonesByZoneAndLang(zone, lang));
    }

    @GetMapping("/schools/{divZoneId}")
    public ResponseEntity<List<MetaDataDTO>> getAllSchoolsByDivZoneAndLang(@PathVariable("divZoneId") Integer divZone,
                                                                           @RequestParam(defaultValue = "en") String lang) {
        return ResponseEntity.ok().body(metaDataService.getAllSchoolsByDivZoneAndLang(divZone, lang));
    }

    @GetMapping("/banks")
    public ResponseEntity<List<GenericRestModel.MetaDataResponseDTO>> getAllBanks() {
        return ResponseEntity.ok().body(metaDataService.getAllBanks());
    }

    @GetMapping("/branches/{bankId}")
    public ResponseEntity<List<GenericRestModel.MetaDataResponseDTO>> getAllBranchesByBankd(@PathVariable("bankId") Integer bank) {
        return ResponseEntity.ok().body(metaDataService.getAllBranchesByBankd(bank));
    }

    @GetMapping("/classes")
    public ResponseEntity<List<MetaDataDTO>> getAllClasses() {
        return ResponseEntity.ok().body(metaDataService.getAllClasses());
    }

    @GetMapping("/grades")
    public ResponseEntity<List<MetaDataDTO>> getAllGrades() {
        return ResponseEntity.ok().body(metaDataService.getAllGrades());
    }

    @GetMapping("/campaigns")
    public ResponseEntity<List<MetaDataDTO>> getAllCampaigns() {
        return ResponseEntity.ok().body(metaDataService.getAllCampaigns());
    }

    @GetMapping("/i18n")
    public Map<String, String> getAllCampaigns(@RequestParam(defaultValue = "en") String lang,
                                               @RequestParam(defaultValue = "en") ModuleName module) {
        return metaDataService.getAlli18nValuesByModuleAndLang(module, lang);
    }

    @PostMapping("/internal")
    public ResponseEntity<Void> evictAllRegions() {
        cacheService.evictAllRegions();
        return ResponseEntity.ok().build();
    }

}
