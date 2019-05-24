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
@Table(name = "rule_expression_group")
public class RuleExpressionGroup implements Comparable<RuleExpressionGroup> {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	@NotNull
	private String id;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "rule_id", nullable = true)
	private LaborRule laborRule;

	@Column
	private String name;

	@Column(name = "order_by")
	private int sequence;

	@OneToMany(mappedBy = "ruleExpressionGroup", cascade = CascadeType.ALL)
	private List<RuleExpressions> ruleExpression = new ArrayList<>();

	public List<RuleExpressions> getRuleExpression() {
		return ruleExpression;
	}

	public void setRuleExpression(List<RuleExpressions> ruleExpression) {
		this.ruleExpression = ruleExpression;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LaborRule getLaborRule() {
		return laborRule;
	}

	public void setLaborRule(LaborRule laborRule) {
		this.laborRule = laborRule;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	@Override
	public int compareTo(RuleExpressionGroup o) {
		return (this.getSequence() < o.getSequence() ? -1 : (this.getSequence() == o.getSequence() ? 0 : 1));
	}

	@Override
	public boolean equals(Object arg0) {
		return super.equals(arg0);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
