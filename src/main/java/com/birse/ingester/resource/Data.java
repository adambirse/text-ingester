package com.birse.ingester.resource;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class Data {

    @NotBlank
    private String text;

    private LocalDateTime date;

    public Data() {
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
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
