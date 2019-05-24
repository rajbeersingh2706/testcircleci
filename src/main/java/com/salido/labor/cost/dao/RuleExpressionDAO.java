package com.salido.labor.cost.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salido.labor.bean.RuleExpressions;

@Repository
public interface RuleExpressionDAO extends JpaRepository<RuleExpressions, String> {

    List<RuleExpressions> getRuleExpressionsByRuleExpressionGroupId(final String expGrpId);

}
