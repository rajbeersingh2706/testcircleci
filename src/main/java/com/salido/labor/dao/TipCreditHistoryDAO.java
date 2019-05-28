package com.salido.labor.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.salido.labor.bean.LocationTipCreditsHistory;

@Repository
public interface TipCreditHistoryDAO extends JpaRepository<LocationTipCreditsHistory, String> {

}
