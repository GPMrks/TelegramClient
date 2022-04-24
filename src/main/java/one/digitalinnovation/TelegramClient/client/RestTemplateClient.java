package one.digitalinnovation.TelegramClient.client;

import one.digitalinnovation.TelegramClient.dto.MessageSend;
import one.digitalinnovation.TelegramClient.dto.ResultBotTelegram;
import one.digitalinnovation.TelegramClient.dto.ResultBotTelegramList;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class RestTemplateClient {

    @Value("${telegram.api}")
    private String BASE_PATH;

    @Value("${telegram.token}")
    private String TOKEN;

    public RestTemplate restTemplate;

    public RestTemplateClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void sendMessage(MessageSend msg){

        //postForLocation retornando a uri, Pega informação do header
        URI uri = restTemplate.postForLocation(BASE_PATH + TOKEN + "/sendMessage", msg);

        //postForLocation retornando o objeto que eu definir de retorno
        ResultBotTelegram return1 = restTemplate.postForObject(BASE_PATH + TOKEN + "/sendMessage", msg, ResultBotTelegram.class);

        //postForLocation retornando o objeto que eu definir de retorno com dados da requisição, Headers,HTTP status...
        ResponseEntity<ResultBotTelegram> return2 = restTemplate.postForEntity(BASE_PATH + TOKEN + "/sendMessage", msg, ResultBotTelegram.class);

        //postForLocation retornando o objeto que eu definir de retorno com dados da requisição, Headers,HTTP status...
        //Enviando Headers
        HttpHeaders headers = headers();
        HttpEntity<MessageSend> request = new HttpEntity<>(msg, headers);
        ResponseEntity<ResultBotTelegram> return3 = restTemplate.postForEntity(BASE_PATH + TOKEN + "/sendMessage", request, ResultBotTelegram.class);

        //exchange
        HttpHeaders headers1 = headers();
        HttpEntity<MessageSend> request1 = new HttpEntity<>(msg, headers1);
        ResponseEntity<ResultBotTelegram> return4 = restTemplate.exchange(BASE_PATH + TOKEN + "/sendMessage", HttpMethod.POST, request1, ResultBotTelegram.class);


    }

    public ResultBotTelegramList getUpdates(){
        ResultBotTelegramList forObject = restTemplate.getForObject(BASE_PATH + TOKEN + "/getUpdates", ResultBotTelegramList.class);
        return forObject;
    }

    private HttpHeaders headers(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("MY_HEADER", "MY_VALUE");
        return headers;
    }


}
