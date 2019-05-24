package com.salido.labor.cost.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.salido.labor.bean.RuleExpressionParam;

@Transactional
@Repository
public interface RuleExpressionParamDAO extends JpaRepository<RuleExpressionParam, String> {

    public List<RuleExpressionParam> findByRuleExpressionId(String expressionId);
}
