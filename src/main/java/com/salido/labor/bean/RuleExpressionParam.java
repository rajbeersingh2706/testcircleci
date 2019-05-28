package com.salido.labor.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "rule_exp_param")
public class RuleExpressionParam {
    @Id
    @Column(name = "id")
    @NotNull
    private String id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "rule_exp_id", nullable = true)
    private RuleExpressions ruleExpression;

    @Column
    private String expKey;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RuleExpressions getRuleExpression() {
        return ruleExpression;
    }

    public void setRuleExpression(RuleExpressions ruleExpression) {
        this.ruleExpression = ruleExpression;
    }

    public String getExpKey() {
        return expKey;
    }

    public void setExpKey(String expKey) {
        this.expKey = expKey;
    }

}
