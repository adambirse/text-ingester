package com.birse.ingester.resource;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Data {

    @NotBlank
    private String text;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    public Data() {
        date = LocalDate.now();
    }

    public Data(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Data{" +
                "text='" + text + '\'' +
                ", date=" + date +
                '}';
    }
}
