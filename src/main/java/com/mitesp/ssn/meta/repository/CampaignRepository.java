package com.mitesp.ssn.meta.repository;

import com.mitesp.ssn.meta.entity.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignRepository extends JpaRepository<Campaign, Integer> {
}