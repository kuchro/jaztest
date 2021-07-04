package com.jaztest.jazs21912nbp.model;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;

@Entity
public class ExchangeRateData {
    @Id
    @GeneratedValue
    private Long id;
    @Enumerated(EnumType.STRING)
    private OreData oreData;
    private LocalDate beginDate;
    private LocalDate endDate;
    private double averageRate;
    private Instant dateAndTimeOfQuery;

    public ExchangeRateData(OreData oreData, LocalDate beginDate, LocalDate endDate, double averageRate, Instant dateAndTimeOfQuery) {
        this.oreData = oreData;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.averageRate = averageRate;
        this.dateAndTimeOfQuery = dateAndTimeOfQuery;
    }

    public ExchangeRateData() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OreData getOreData() {
        return oreData;
    }

    public void setOreData(OreData oreData) {
        this.oreData = oreData;
    }

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public double getAverageRate() {
        return averageRate;
    }

    public void setAverageRate(double averageRate) {
        this.averageRate = averageRate;
    }

    public Instant getDateAndTimeOfQuery() {
        return dateAndTimeOfQuery;
    }

    public void setDateAndTimeOfQuery(Instant dateAndTimeOfQuery) {
        this.dateAndTimeOfQuery = dateAndTimeOfQuery;
    }
}
