package com.salido.labor.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "labor_rule")
public class LaborRule extends BaseBean {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "rule_id")
	@NotNull
	private String ruleId;

	@Column
	private String name;

	@Column(length = 3000)
	private String description;

	@Column(name = "rule_tag")
	private String ruleTag;

	@Column(name = "order_by")
	private int sequence;

	public void addLaborLocation(LaborRuleLocation laborRuleLocation) {
		this.laborRuleLocations.add(laborRuleLocation);
	}

	@OneToMany(mappedBy = "primaryKey.laborRule", cascade = CascadeType.ALL)
	private List<LaborRuleLocation> laborRuleLocations = new ArrayList<>();

	@OneToMany(mappedBy = "laborRule", cascade = CascadeType.ALL)
	private List<RuleExpressionGroup> ruleExpressionGroup = new ArrayList<>();

	public List<RuleExpressionGroup> getRuleExpressionGroup() {
		return ruleExpressionGroup;
	}

	public void setRuleExpressionGroup(List<RuleExpressionGroup> ruleExpressionGroup) {
		this.ruleExpressionGroup = ruleExpressionGroup;
	}

	public List<LaborRuleLocation> getLaborRuleLocations() {
		return laborRuleLocations;
	}

	public void setLaborRuleLocations(List<LaborRuleLocation> laborRuleLocations) {
		this.laborRuleLocations = laborRuleLocations;
	}

	public void addLaborRuleLocation(LaborRuleLocation laborRuleLocation) {
		this.laborRuleLocations.add(laborRuleLocation);
	}

	public String getRuleId() {
		return ruleId;
	}

	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRuleTag() {
		return ruleTag;
	}

	public void setRuleTag(String ruleTag) {
		this.ruleTag = ruleTag;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public LaborRule() {

	}

	public LaborRule(String id, String name, String description, String ruleTag, int sequence) {
		this.ruleId = id;
		this.name = name;
		this.description = description;
		this.ruleTag = ruleTag;
		this.sequence = sequence;
	}

}