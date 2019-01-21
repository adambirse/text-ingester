package com.birse.ingester.domain;

import java.time.LocalDateTime;

/**
 * Domain class used by Kafka
 */
public class Text {

    private Long id;
    private LocalDateTime time;
    private String text;

    public Text() {
        id = RandomIDGenerator.generateLong();
    }
    public Text(String text) {
        id = RandomIDGenerator.generateLong();
        this.text = text;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Text{" +
                "id=" + id +
                ", time=" + time +
                ", text='" + text + '\'' +
                '}';
    }
}
