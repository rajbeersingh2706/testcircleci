package com.salido.labor.dto;

import java.util.Date;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseDTO {

    private Date createdDate;
    private String createdBy;
    private String updatedBy;
    private Date updatedDate;

    public Date getCreatedDate() {
        return getMutableDate(createdDate);
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = getMutableDate(createdDate);

    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedDate() {
        return getMutableDate(updatedDate);
    }

    public void setUpdatedDate(Date updatedDate) {

        this.updatedDate = getMutableDate(updatedDate);

    }

    public Date getMutableDate(Date date) {
        return date != null ? (Date) date.clone() : null;
    }

    @Override
    public String toString() {
        return " Created Date=" + createdDate + ", createdBy=" + createdBy + ", updatedDate=" + updatedDate
                + ", updatedBy=" + updatedBy + "]";
    }
}
