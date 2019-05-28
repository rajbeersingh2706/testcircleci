package com.salido.labor.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.salido.labor.bean.LaborRule;


@Transactional
@Repository
public interface LaborRuleDAO extends JpaRepository<LaborRule, String> {

}
