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
@Table(name = "rule_expression_result")
public class RuleExpressionResult extends BaseBean implements Comparable<RuleExpressionResult> {

	@Id
	@Column(name = "id")
	@NotNull
	private String id;

	@Column
	private String timeframe;

	@Column
	private String rate;

	@Column(name = "modifire", length = 1000)
	private String modifier;

	@Column(name = "hours_paid_measure")
	private String hoursPaidMeasure;

	@Column(name = "hours_paid_value")
	private String hoursPaidValue;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "rule_exp_id", nullable = true)
	private RuleExpressions ruleExpression;

	@Column(name = "order_by")
	private int sequence;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTimeframe() {
		return timeframe;
	}

	public void setTimeframe(String timeframe) {
		this.timeframe = timeframe;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public String getHoursPaidMeasure() {
		return hoursPaidMeasure;
	}

	public void setHoursPaidMeasure(String hoursPaidMeasure) {
		this.hoursPaidMeasure = hoursPaidMeasure;
	}

	public RuleExpressions getRuleExpression() {
		return ruleExpression;
	}

	public void setRuleExpression(RuleExpressions ruleExpression) {
		this.ruleExpression = ruleExpression;
	}

	public String getHoursPaidValue() {
		return hoursPaidValue;
	}

	public void setHoursPaidValue(String hoursPaidValue) {
		this.hoursPaidValue = hoursPaidValue;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	@Override
	public int compareTo(RuleExpressionResult o) {
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
