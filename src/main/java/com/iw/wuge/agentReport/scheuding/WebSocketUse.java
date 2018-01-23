package com.iw.wuge.agentReport.scheuding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebSocketUse {

    @Autowired
    private SimpMessagingTemplate template;

    public static void main(String[] args) {
        template.convertAndSend("/topic/collectionMessage",message);
    }
}
