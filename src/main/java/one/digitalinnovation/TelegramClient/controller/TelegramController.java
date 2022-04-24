package one.digitalinnovation.TelegramClient.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import one.digitalinnovation.TelegramClient.dto.MessageSend;
import one.digitalinnovation.TelegramClient.dto.ResultBotTelegramList;
import one.digitalinnovation.TelegramClient.service.TelegramService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/telegram")
public class TelegramController {

        private TelegramService telegramService;
        private ObjectMapper objectMapper;

    public TelegramController(TelegramService telegramService, ObjectMapper objectMapper) {
        this.telegramService = telegramService;
        this.objectMapper = objectMapper;
    }

    @PostMapping
    public ResponseEntity createMessage(@RequestBody MessageSend msg){
        System.out.println("Entered Post");
        telegramService.sendMessage(msg);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<ResultBotTelegramList> getMessages(){
        System.out.println("Entered Get");
        ResultBotTelegramList getUpdatesResultBotTelegram = telegramService.getUpdates();
        return ResponseEntity.ok(getUpdatesResultBotTelegram);
    }
}
