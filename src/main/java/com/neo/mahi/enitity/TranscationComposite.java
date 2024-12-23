package com.neo.mahi.enitity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Objects;

public class TranscationComposite implements Serializable {

    private Timestamp startDate;
    private Timestamp endDate;

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }



    public TranscationComposite() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TranscationComposite that = (TranscationComposite) o;
        return Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, endDate);
    }

    @Override
    public String toString() {
        return "TranscationComposite{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
