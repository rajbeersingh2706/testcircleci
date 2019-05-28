package com.salido.labor.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "location_tipcredits")
public class LocationTipCredits extends BaseBean {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Column
    private String id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "location_id", nullable = true)
    private LaborLocation laborLocation;

    @Column
    private String tipCredit;

    @Column
    private String brandId;

    @Column
    private String orgId;

    @Column
    private Date startDate;

    @Column
    private Date endDate;

    @Column
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LaborLocation getLaborLocation() {
        return laborLocation;
    }

    public void setLaborLocation(LaborLocation laborLocation) {
        this.laborLocation = laborLocation;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getTipCredit() {
        return tipCredit;
    }

    public void setTipCredit(String tipCredit) {
        this.tipCredit = tipCredit;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}