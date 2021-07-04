package com.jaztest.jazs21912nbp.model;

import io.swagger.annotations.ApiModelProperty;

import java.time.Instant;
import java.time.LocalDate;

public class ExchangeRateDataDto {
    @ApiModelProperty(notes = "Kruszec")
    private OreData oreData;
    @ApiModelProperty(notes = "Zakres poczatkowy")
    private LocalDate beginDate;
    @ApiModelProperty(notes = "Zakres koncowy")
    private LocalDate endDate;
    @ApiModelProperty(notes = "Srednia wartosc kruszca")
    private double averageRate;
    @ApiModelProperty(notes = "Data i czas wykonania zapytania.")
    private Instant dateAndTimeOfQuery;

    public ExchangeRateDataDto(OreData oreData, LocalDate beginDate, LocalDate endDate, double averageRate, Instant dateAndTimeOfQuery) {
        this.oreData = oreData;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.averageRate = averageRate;
        this.dateAndTimeOfQuery = dateAndTimeOfQuery;
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
