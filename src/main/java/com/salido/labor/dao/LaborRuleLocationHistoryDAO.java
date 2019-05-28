package com.salido.labor.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salido.labor.bean.LaborRuleLocationHistory;

@Repository
public interface LaborRuleLocationHistoryDAO extends JpaRepository<LaborRuleLocationHistory, String> {

    List<LaborRuleLocationHistory> findByLocationIdAndRuleIdOrderByCreatedDateDesc(String locationId, String ruleId);

}
