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
@Table(name = "labor_location")
public class LaborLocation {

    private static final long serialVersionUID = 1L;

    public LaborLocation() {

    }

    public LaborLocation(String id, String name) {
        this.locationId = id;
        this.locationName = name;
    }

    public LaborLocation(String id) {
        this.locationId = id;

    }

    @Id
    @Column(name = "location_id")
    @NotNull
    private String locationId;

    @OneToMany(mappedBy = "primaryKey.laborLocation", cascade = CascadeType.ALL)
    private List<LaborRuleLocation> laborRuleLocations = new ArrayList<>();

    @OneToMany(mappedBy = "laborLocation", cascade = CascadeType.ALL)
    private List<LocationMinWage> locationMinWage;

    @OneToMany(mappedBy = "laborLocation", cascade = CascadeType.ALL)
    private List<LocationTipCredits> locationTipCredits;

    @Column(name = "location_name")
    public String locationName;

    public List<LocationMinWage> getLocationMinWage() {
        return locationMinWage;
    }

    public void setLocationMinWage(List<LocationMinWage> locationMinWage) {
        this.locationMinWage = locationMinWage;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public List<LaborRuleLocation> getLaborRuleLocations() {
        return laborRuleLocations;
    }

    public void setLaborRuleLocations(List<LaborRuleLocation> laborRuleLocations) {
        this.laborRuleLocations = laborRuleLocations;
    }

    public void addLaborRuleLocation(LaborRuleLocation laborRuleLocations) {
        this.laborRuleLocations.add(laborRuleLocations);
    }

}