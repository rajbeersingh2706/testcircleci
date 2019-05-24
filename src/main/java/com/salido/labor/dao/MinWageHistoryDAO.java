package com.salido.labor.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salido.labor.bean.LocationMinWageHistory;

@Repository
public interface MinWageHistoryDAO extends JpaRepository<LocationMinWageHistory,String> {

}
