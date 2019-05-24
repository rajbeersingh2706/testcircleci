package com.salido.labor.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "location_tipcredits_h")
public class LocationTipCreditsHistory {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "tip_credit")
    private String tipCredit;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "location_id")
    private String locationId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "created_date")
    private Date createdDate;

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

    public Date getCreatedDate() {
        return getMutableDate(createdDate);
    }

    public void setCreatedDate(Date createdDate) {
        this.startDate = getMutableDate(createdDate);
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public Date getMutableDate(Date date) {
        return date != null ? new Date(date.getTime()) : null;
    }

}