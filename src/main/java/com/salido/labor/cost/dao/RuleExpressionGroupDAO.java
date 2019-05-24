package com.salido.labor.cost.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salido.labor.bean.RuleExpressionGroup;

@Repository
public interface RuleExpressionGroupDAO extends JpaRepository<RuleExpressionGroup, String> {

    List<RuleExpressionGroup> getExpressionGroupsByLaborRuleRuleId(final String ruleId);

}
