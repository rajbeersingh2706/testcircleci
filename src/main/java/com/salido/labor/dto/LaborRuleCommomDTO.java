package com.salido.labor.dto;

import java.util.Arrays;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.salido.labor.exception.SalidoLaborBusinessException;
import com.salido.labor.util.DateUtils;

public class LaborRuleCommomDTO extends BaseDTO {

    private String orgId;

    private String brandId;

    private String locationId;

    private String startDate;

    private String endDate;

    private String status;

    private Location[] locations;

    @Autowired
    DateUtils dateutils;

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

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Location[] getLocations() {
        return locations != null ? (Location[]) locations.clone() : null;
    }

    public void setLocations(Location[] locations) {
        this.locations = locations != null ? (Location[]) locations.clone() : null;
    }

    public void validateCommonInput(LaborRuleCommomDTO commomDTO) {
        if (StringUtils.isBlank(commomDTO.getOrgId())) {
            throw new SalidoLaborBusinessException("Organization key not found");
        } else if (StringUtils.isBlank(commomDTO.getBrandId())) {
            throw new SalidoLaborBusinessException("Brand key not found");
        }
    }

    public void validateInput(LaborRuleCommomDTO commomDTO) {
        if (StringUtils.isBlank(commomDTO.getCreatedBy())) {
            throw new SalidoLaborBusinessException("created by key not found");
        } else if (StringUtils.isBlank(commomDTO.getStartDate())) {
            throw new SalidoLaborBusinessException("start date not found");
        }
    }

    public void validateLocation(LaborRuleCommomDTO commomDTO) {
        if (commomDTO.getLocations() == null) {
            throw new SalidoLaborBusinessException("LocationId/Location Name key is missing.");
        } else {
            Location[] locationArr = commomDTO.getLocations();
            for (Location location : locationArr) {
                if (StringUtils.isBlank(location.getLocationId()) || StringUtils.isBlank(location.getLocationName())) {
                    throw new SalidoLaborBusinessException("LocationId/Location Name key is missing.");
                }
            }
        }
    }

    public void validateLocation(String locationId) {
        if (StringUtils.isBlank(locationId)) {
            throw new SalidoLaborBusinessException("LocationId key is missing.");
        }
    }

    @Override
    public String toString() {
        return " orgId=" + orgId + ", brandId=" + brandId + ", locationId=" + locationId + ", startDate=" + startDate
                + ", endDate=" + endDate + " locations=" + (locations != null ? getLocations(locations) : "[ ]")
                + super.toString() + "]";
    }

    private String getLocations(Location[] locations) {
        StringBuilder builder = new StringBuilder();
        Arrays.stream(locations).forEach(location -> {
            if (StringUtils.isNotBlank(builder.toString())) {
                builder.append("#");
            }
            builder.append(location.toString());
        });
        builder.append("]");
        return "[" + builder.toString();
    }

    public boolean validateDates() {
        if (StringUtils.isNotBlank(this.endDate)) {
            dateutils = new DateUtils();
            Date startDt = dateutils.stringToDate(this.startDate, DateUtils.DATE_FORMAT_COMMON);
            Date endDt = dateutils.stringToDate(this.endDate, DateUtils.DATE_FORMAT_COMMON);
            // -1==> endDt date < parameter date (startDt)
            if (endDt.compareTo(startDt) == -1) {
                throw new SalidoLaborBusinessException("End date can not be smaller than start date");
            }
        }
        return true;
    }

}
