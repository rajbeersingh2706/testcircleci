package com.salido.labor.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "labor_rule_location_h")
public class LaborRuleLocationHistory {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "location_id")
    private String locationId;

    @Column(name = "rule_id")
    private String ruleId;

    @Column(name = "start_date")
    @NotNull
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "created_date")
    private Date createdDate;

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getRuleId() {
        return ruleId;
    }

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getCreatedDate() {
        return getMutableDate(createdDate);
    }

    public void setCreatedDate(Date createdDate) {
        this.startDate = getMutableDate(createdDate);
    }

    public Date getMutableDate(Date date) {
        return date != null ? new Date(date.getTime()) : null;
    }

}