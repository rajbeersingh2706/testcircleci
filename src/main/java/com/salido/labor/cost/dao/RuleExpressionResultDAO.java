package com.salido.labor.cost.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salido.labor.bean.RuleExpressionResult;

@Repository
public interface RuleExpressionResultDAO extends JpaRepository<RuleExpressionResult, String> {

    List<RuleExpressionResult> getRuleExpressionResultsByRuleExpressionId(final String ruleExpCondId);

}
