package one.digitalinnovation.TelegramClient.service;

import one.digitalinnovation.TelegramClient.client.FeignClient;
import one.digitalinnovation.TelegramClient.client.JavaHttpClient;
import one.digitalinnovation.TelegramClient.client.RestTemplateClient;
import one.digitalinnovation.TelegramClient.dto.MessageSend;
import one.digitalinnovation.TelegramClient.dto.ResultBotTelegram;
import one.digitalinnovation.TelegramClient.dto.ResultBotTelegramList;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TelegramService {

    private RestTemplateClient restTemplateClient;
    private FeignClient feignClient;
    private JavaHttpClient javaHttpClient;

    public TelegramService(RestTemplateClient restTemplateClient, FeignClient feignClient, JavaHttpClient javaHttpClient) {
        this.restTemplateClient = restTemplateClient;
        this.feignClient = feignClient;
        this.javaHttpClient = javaHttpClient;
    }

    public void sendMessage(MessageSend message){

        //HTTP CLIENT
        //ResultBotTelegram resultBotTelegramResponseEntity = javaHttpClient.sendMessage(message);

        //REST TEMPLATE
        //restTemplateClient.sendMessage(message);

        //FEIGN_CLIENT
        ResponseEntity<ResultBotTelegram> resultBotTelegram = feignClient.sendMessage(message);

    }

    public ResultBotTelegramList getUpdates(){

        //HTTP CLIENT
        ResultBotTelegramList resultBotTelegramList = javaHttpClient.getUpdates();

        //REST TEMPLATE
        ResultBotTelegramList resultBotTelegramList1 = restTemplateClient.getUpdates();

        //FEIGN CLIENT
        ResponseEntity<ResultBotTelegramList> resultBotTelegramList2 = feignClient.getUpdates();
        return resultBotTelegramList2.getBody();
    }

}
