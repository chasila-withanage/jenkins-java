package com.mitesp.ssn.meta.service;

import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CacheService {

    private final SessionFactory sessionFactory;

    public void evictAllRegions() {
        sessionFactory.getCache().evictRegion("Bank");
        sessionFactory.getCache().evictRegion("Branch");
        sessionFactory.getCache().evictRegion("Campaign");
        sessionFactory.getCache().evictRegion("DistrictLocal");
        sessionFactory.getCache().evictRegion("Class");
        sessionFactory.getCache().evictRegion("District");
        sessionFactory.getCache().evictRegion("DivisionalEducationOffice");
        sessionFactory.getCache().evictRegion("DivisionalEducationOfficeLocal");
        sessionFactory.getCache().evictRegion("DivSecretariat");
        sessionFactory.getCache().evictRegion("DivSecretariatLocal");
        sessionFactory.getCache().evictRegion("Grade");
        sessionFactory.getCache().evictRegion("GramasevaDivision");
        sessionFactory.getCache().evictRegion("GramasevaDivisionLocal");
        sessionFactory.getCache().evictRegion("I18n");
        sessionFactory.getCache().evictRegion("Province");
        sessionFactory.getCache().evictRegion("ProvinceLocal");
        sessionFactory.getCache().evictRegion("School");
        sessionFactory.getCache().evictRegion("SchoolLocal");
        sessionFactory.getCache().evictRegion("ZonalEducationOffice");
        sessionFactory.getCache().evictRegion("ZonalEducationOfficeLocal");
    }
}
