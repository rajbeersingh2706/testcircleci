package com.salido.labor.dto;

import org.apache.commons.lang.StringUtils;

import com.salido.labor.exception.SalidoLaborBusinessException;

public class LaborRuleLocationDTO extends LaborRuleCommomDTO {

    private String ruleTag;
    private String description;
    private String ruleId;
    private String locationName;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRuleId() {
        return ruleId;
    }

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getRuleTag() {
        return ruleTag;
    }

    public void setRuleTag(String ruleTag) {
        this.ruleTag = ruleTag;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean validateListAppliedRule() {
        validateCommonInput(this);
        validateLocation(this);
        return true;
    }

    public boolean validateListAllRules() {
        validateCommonInput(this);
        validateLocation(this.getLocationId());
        return true;
    }

    public boolean validateApplyRule() {
        validateCommonInput(this);
        validateLocation(this.getLocationId());
        validateInput(this);
        if (StringUtils.isBlank(this.getRuleId())) {
            throw new SalidoLaborBusinessException("Rule Id not found");
        }
        return true;
    }

    @Override
    public String toString() {
        return "LaborRuleLocationDTO [ruleTag=" + ruleTag + ", description=" + description + ", ruleId=" + ruleId
                + ", locationName=" + locationName + ", name=" + name + super.toString() + "]";
    }

}
