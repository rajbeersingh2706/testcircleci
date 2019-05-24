package com.salido.labor.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "rule_expressions")
public class RuleExpressions extends BaseBean implements Comparable<RuleExpressions> {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@NotNull
	private String id;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "exp_grp_id", nullable = true)
	private RuleExpressionGroup ruleExpressionGroup;

	@Column
	@OneToMany(mappedBy = "ruleExpression", cascade = CascadeType.ALL)
	private List<RuleExpressionResult> expressionResult = new ArrayList<>();

	@Column
	@OneToMany(mappedBy = "ruleExpression", cascade = CascadeType.ALL)
	private List<RuleExpressionParam> expressionParams = new ArrayList<>();

	@Column(name = "expression")
	private String expression;

	@Column(name = "pre_condition")
	private String preCondition;

	@Column(name = "order_by")
	private int sequence;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public RuleExpressionGroup getRuleExpressionGroup() {
		return ruleExpressionGroup;
	}

	public void setRuleExpressionGroup(RuleExpressionGroup ruleExpressionGroup) {
		this.ruleExpressionGroup = ruleExpressionGroup;
	}

	public List<RuleExpressionResult> getExpressionResult() {
		return expressionResult;
	}

	public void setExpressionResult(List<RuleExpressionResult> expressionResult) {
		this.expressionResult = expressionResult;
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public String getPreCondition() {
		return preCondition;
	}

	public void setPreCondition(String preCondition) {
		this.preCondition = preCondition;
	}

	public List<RuleExpressionParam> getExpressionParams() {
		return expressionParams;
	}

	public void setExpressionParams(List<RuleExpressionParam> expressionParams) {
		this.expressionParams = expressionParams;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	@Override
	public int compareTo(RuleExpressions o) {
		return (this.getSequence() < o.getSequence() ? -1 : (this.getSequence() == o.getSequence() ? 0 : 1));
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

}
