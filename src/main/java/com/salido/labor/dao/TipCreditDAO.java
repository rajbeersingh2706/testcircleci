package com.salido.labor.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.salido.labor.bean.LocationTipCredits;

@Transactional
@Repository
public interface TipCreditDAO extends JpaRepository<LocationTipCredits, String> {

	List<LocationTipCredits> findByOrgIdAndBrandIdAndLaborLocationLocationIdOrderByStartDate(final String orgId,
			final String brandId, final String locationId);

	List<LocationTipCredits> findByLaborLocationLocationId(final String locationId);

	@Query("SELECT lt from LocationTipCredits lt JOIN lt.laborLocation v "
			+ " WHERE v.locationId=:locationId  AND lt.startDate<=:tcStartDate AND (lt.endDate>=:tcStartDate OR lt.endDate is null) ORDER BY lt.startDate DESC")
	List<LocationTipCredits> listTipCredits(@Param("locationId") final String locationId,@Param("tcStartDate") Date tcStartDate);
}
