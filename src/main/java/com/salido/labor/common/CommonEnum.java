/**
<h4>Description</h4>
 * @author Amit Rathi
 * 
 */
package com.salido.labor.common;

public enum CommonEnum {

    STATUS_ENABLED("A"), STATUS_DISABLED("D"), STATUS_ACTIVE("1"), STATUS_INACTIVE("0"), STATUS_LOGINSUCCESS(
            "1"), STATUS_LOGINBADATTEMPT("0"), STATUS_DELETE("D"), PWD_POLICY_CRITERIA_YES("A"), PWD_POLICY_CRITERIA_NO(
                    "A"), PWD_POLICY_ENABLED("1"), PWD_POLICY_DISABLED("2"), LOGINBADATTEMPT(
                            "Badattempt"), LOGINSUCCSSATTEMPT("Login"), LOGOUTATTEMPT("Logout"), STATUS_ACTIVE_STR(
                                    "Active"), STATUS_SCHEDULED("Scheduled"), STATUS_EXPIRED("Inactive");

    private String value;

    CommonEnum(String value) {
        this.value = value;
    }

    /**
     * Gets the value.
     * 
     * @return the value
     */
    public String getValue() {
        return value;
    }

}
