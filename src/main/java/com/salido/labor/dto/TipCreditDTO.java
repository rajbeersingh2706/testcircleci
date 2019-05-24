package com.salido.labor.dto;

import org.apache.commons.lang.StringUtils;

import com.salido.labor.exception.SalidoLaborBusinessException;

public class TipCreditDTO extends LaborRuleCommomDTO {

    private String id;

    private String tipCredit;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipCredit() {
        return tipCredit;
    }

    public void setTipCredit(String tipCredit) {
        this.tipCredit = tipCredit;
    }

    public boolean validateAddTipCredit() {
        validateCommonInput(this);
        validateLocation(this.getLocationId());
        validateInput(this);
        if (StringUtils.isBlank(this.getTipCredit())) {
            throw new SalidoLaborBusinessException("Tip credit not found");
        }
        return true;
    }

    public boolean validateListTipCredit() {
        validateCommonInput(this);
        validateLocation(this);
        return true;
    }

    @Override
    public String toString() {
        return "TipCreditDTO [id=" + id + ", tipCredit=" + tipCredit + super.toString() + "]";
    }

}
