package com.salido.labor.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.salido.labor.bean.LocationMinWage;
@Transactional
@Repository
public interface MinWageDAO extends JpaRepository<LocationMinWage, String>{
	
	

	List<LocationMinWage> findByOrgIdAndBrandIdAndLaborLocationLocationIdOrderByStartDate(final String orgId,
			final String brandId, final String locationId);

	List<LocationMinWage> findByLaborLocationLocationId(final String locationId);
	
	
	@Query("SELECT lm from LocationMinWage lm JOIN lm.laborLocation v "
			+ " WHERE v.locationId=:locationId  AND lm.startDate<=:tcStartDate AND (lm.endDate>=:tcStartDate OR lm.endDate is null) ORDER BY lm.startDate DESC")
	List<LocationMinWage> listMinWage(@Param("locationId") final String locationId,@Param("tcStartDate") Date tcStartDate);
	
	
}
