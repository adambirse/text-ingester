package com.birse.ingester.service;

import com.birse.ingester.domain.Text;
import com.birse.ingester.messaging.TextSender;
import com.birse.ingester.resource.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TextService {

    private final TextSender sender;

    @Autowired
    TextService(final TextSender sender) {
        this.sender = sender;
    }

    public void send(Data data) {
        sender.send(construct(data));
    }

    private Text construct(Data data) {
        Text text = new Text();
        text.setTime(data.getDate() != null ? data.getDate() : LocalDateTime.now());
        text.setText(data.getText());
        return text;
    }

}
