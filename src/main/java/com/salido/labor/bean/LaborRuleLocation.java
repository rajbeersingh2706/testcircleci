package com.salido.labor.bean;

import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity

@Table(name = "labor_rule_location")
@AssociationOverrides({
        @AssociationOverride(name = "primaryKey.laborRule", joinColumns = @JoinColumn(name = "rule_id")),
        @AssociationOverride(name = "primaryKey.laborLocation", joinColumns = @JoinColumn(name = "location_id")) })

public class LaborRuleLocation extends BaseBean {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    // composite-id key
    private RuleLocationId primaryKey = new RuleLocationId();

    @EmbeddedId
    public RuleLocationId getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(RuleLocationId primaryKey) {
        this.primaryKey = primaryKey;
    }

    @Transient
    public LaborRule getLaborRule() {
        return getPrimaryKey().getLaborRule();
    }

    @Transient
    public LaborLocation getLaborLocation() {
        return getPrimaryKey().getLaborLocation();
    }

    public void setLaborRule(LaborRule laborRule) {
        getPrimaryKey().setLaborRule(laborRule);
    }

    public void setLaborLocation(LaborLocation laborLocation) {
        getPrimaryKey().setLaborLocation(laborLocation);
    }

    @Column(name = "org_id")
    @NotNull
    private String orgId;
    @NotNull
    @Column(name = "brand_id")
    @NotNull
    private String brandId;

    @Column(name = "start_date")
    @NotNull
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "timecards_update_status")
    private boolean timecardsUpdateStatus = false;

    @Column
    private String status;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public Date getStartDate() {
        return getMutableDate(startDate);
    }

    public void setStartDate(Date startDate) {
        this.startDate = getMutableDate(startDate);
    }

    public Date getEndDate() {
        return getMutableDate(endDate);
    }

    public void setEndDate(Date endDate) {
        this.endDate = getMutableDate(endDate);
    }

    public boolean isTimecardsUpdateStatus() {
        return timecardsUpdateStatus;
    }

    public void setTimecardsUpdateStatus(boolean timecardsUpdateStatus) {
        this.timecardsUpdateStatus = timecardsUpdateStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}