package com.salido.labor.dto;

import org.apache.commons.lang.StringUtils;

import com.salido.labor.exception.SalidoLaborBusinessException;

public class MinWageDTO extends LaborRuleCommomDTO {

    private String id;

    private String minWage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMinWage() {
        return minWage;
    }

    public void setMinWage(String minWage) {
        this.minWage = minWage;
    }

    public boolean validateAddMinWage() {
        validateCommonInput(this);
        validateLocation(this.getLocationId());
        validateInput(this);
        if (StringUtils.isBlank(this.getMinWage())) {
            throw new SalidoLaborBusinessException("Min Wage not found");
        }
        return true;
    }

    public boolean validateListMinWage() {
        validateCommonInput(this);
        validateLocation(this);
        return true;
    }

    @Override
    public String toString() {
        return "MinWageDTO [id=" + id + ", minWage=" + minWage + super.toString() + "]";
    }

}
