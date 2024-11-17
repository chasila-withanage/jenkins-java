package com.mitesp.ssn.meta.service;

import com.mitesp.ssn.meta.entity.I18n;
import com.mitesp.ssn.meta.model.GenericRestModel;
import com.mitesp.ssn.meta.model.MetaDataDTO;
import com.mitesp.ssn.meta.model.ModuleName;
import com.mitesp.ssn.meta.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class MetaDataService {

    private final ProvinceRepository provinceRepository;
    private final DistrictRepository districtRepository;
    private final DivSecretariatRepository divSecretariatRepository;
    private final GramasevaDivisionRepository gramasevaDivisionRepository;
    private final ZonalEducationOfficeRepository zonalEducationOfficeRepository;
    private final DivisionalEducationOfficeRepository divisionalEducationOfficeRepository;
    private final SchoolRepository schoolRepository;
    private final BankRepository bankRepository;
    private final BranchRepository branchRepository;
    private final ClassEntityRepository classEntityRepository;
    private final GradeRepository gradeRepository;
    private final CampaignRepository campaignRepository;
    private final I18nRepository i18nRepository;

    public List<MetaDataDTO> getAllProvincesByLang(String lang) {
        return provinceRepository.findAllProvincesByLang(lang)
                .stream().sorted(Comparator.comparing(MetaDataDTO::label))
                .toList();
    }

    public List<MetaDataDTO> getAllDistrictsByLang(String lang) {
        return districtRepository.findAllDistrictsByLang(lang)
                .stream().sorted(Comparator.comparing(MetaDataDTO::label))
                .toList();
    }

    public List<MetaDataDTO> getAllDivSecsByDistrictAndLang(Integer district, String lang) {
        return divSecretariatRepository.findAllDivsecsByLang(district, lang)
                .stream().sorted(Comparator.comparing(MetaDataDTO::label))
                .toList();
    }

    public List<MetaDataDTO> getAllGsByDsAndLang(Integer ds, String lang) {
        return gramasevaDivisionRepository.findAllGsByLang(ds, lang)
                .stream().sorted(Comparator.comparing(MetaDataDTO::label))
                .toList();
    }

    public List<MetaDataDTO> getAllZonesByLang(String lang) {
        return zonalEducationOfficeRepository.findAllZonalEdusByLang(lang)
                .stream().sorted(Comparator.comparing(MetaDataDTO::label))
                .toList();
    }

    public List<MetaDataDTO> getAllDivZonesByZoneAndLang(Integer zone, String lang) {
        return divisionalEducationOfficeRepository.findAllDivSecByLang(zone, lang)
                .stream().sorted(Comparator.comparing(MetaDataDTO::label))
                .toList();
    }

    public List<MetaDataDTO> getAllSchoolsByDivZoneAndLang(Integer divZone, String lang) {
        return schoolRepository.findAllSchoolsByLang(divZone, lang)
                .stream().sorted(Comparator.comparing(MetaDataDTO::label))
                .toList();
    }

    public List<GenericRestModel.MetaDataResponseDTO> getAllBanks() {
        return bankRepository.findAll().stream()
                .map(b -> GenericRestModel.MetaDataResponseDTO.builder().value(b.getId()).label(b.getBankName())
                        .code(b.getBankCode()).build())
                .sorted(Comparator.comparing(GenericRestModel.MetaDataResponseDTO::label))
                .toList();
    }

    public List<GenericRestModel.MetaDataResponseDTO> getAllBranchesByBankd(Integer bank) {
        return branchRepository.findAllByBank_id(bank).stream()
                .map(b -> GenericRestModel.MetaDataResponseDTO.builder().value(b.getId()).label(b.getBranchName())
                        .code(b.getBranchCode()).build())
                .sorted(Comparator.comparing(GenericRestModel.MetaDataResponseDTO::label))
                .toList();
    }

    public List<MetaDataDTO> getAllGrades() {
        return gradeRepository.findAll()
                .stream().map(r -> MetaDataDTO.builder().value(r.getId()).label(r.getName()).build())
                .sorted(Comparator.comparing(MetaDataDTO::label))
                .toList();
    }

    public List<MetaDataDTO> getAllClasses() {
        return classEntityRepository.findAll()
                .stream().map(r -> MetaDataDTO.builder().value(r.getId()).label(r.getName()).build())
                .sorted(Comparator.comparing(MetaDataDTO::label))
                .toList();
    }

    public List<MetaDataDTO> getAllCampaigns() {
        return campaignRepository.findAll()
                .stream().map(r -> MetaDataDTO.builder().value(r.getId()).label(r.getName()).build())
                .sorted(Comparator.comparing(MetaDataDTO::label))
                .toList();
    }


    public Map<String,String> getAlli18nValuesByModuleAndLang(ModuleName module, String lang){
        return i18nRepository.findAllByi18nLocalAndModule(lang,module)
                .stream().collect(Collectors.toMap(I18n::getLabel, I18n::getLocalVal));
    }
}
