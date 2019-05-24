package com.salido.labor.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.salido.labor.bean.LaborRuleLocation;

@Repository
public interface LaborRuleLocationDAO extends JpaRepository<LaborRuleLocation, String> {

    List<LaborRuleLocation> getRuleLocationBytimecardsUpdateStatus(final boolean status);

    List<LaborRuleLocation> getRuleLocationByPrimaryKeyLaborLocationLocationId(final String locationId);

    LaborRuleLocation getRuleLocationByPrimaryKeyLaborLocationLocationIdAndPrimaryKeyLaborRuleRuleId(
            final String locationId, final String ruleId);
    
    @Query("SELECT lt from LaborRuleLocation lt JOIN lt.primaryKey.laborLocation v JOIN lt.primaryKey.laborRule s"
            + " WHERE v.locationId=:locationId  AND lt.startDate<=:tcStartDate AND (lt.endDate>=:tcStartDate OR lt.endDate is null) ORDER BY s.sequence")
    List<LaborRuleLocation> getRuleList(@Param("locationId") final String locationId, @Param("tcStartDate") Date tcStartDate);

}
