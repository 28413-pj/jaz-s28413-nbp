package com.example.demo;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity

public class CurrencyQuery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Aktualne ID")
    private Long id;

    @Schema(description = "Nazwa waluty")
    private String currency;

    @Schema(description = "Pierwszy dzien")
    private LocalDate firstday;
    @Schema(description = "Ostatni dzien")
    private int lastday;
    @Schema(description = "Srednia cena pomiędzy firstday a lastday")
    private double averageRate;
    @Schema(description = "Data zlozenia requesta")
    private LocalDate queryTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public LocalDate getFirstday() {
        return firstday;
    }

    public void setFirstday(LocalDate firstday) {
        this.firstday = firstday;
    }

    public double getAverageRate() {
        return averageRate;
    }

    public void setAverageRate(double averageRate) {
        this.averageRate = averageRate;
    }

    public LocalDate getQueryTime() {
        return queryTime;
    }

    public void setQueryTime(LocalDate queryTime) {
        this.queryTime = queryTime;
    }
    public int getLastday() {
        return lastday;
    }
    public void setLastday(int lastday) {
        this.lastday = lastday;
    }

}
