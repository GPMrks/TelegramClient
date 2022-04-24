package one.digitalinnovation.TelegramClient.client;

import feign.Headers;
import feign.Param;
import one.digitalinnovation.TelegramClient.dto.MessageSend;
import one.digitalinnovation.TelegramClient.dto.ResultBotTelegram;
import one.digitalinnovation.TelegramClient.dto.ResultBotTelegramList;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@org.springframework.cloud.openfeign.FeignClient(url = "${telegram.api}${telegram.token}", name = "telegram")
public interface FeignClient {

    @GetMapping("/getUpdates")
    ResponseEntity<ResultBotTelegramList> getUpdates();

//    @Headers("MY_HEADER: {my_header}")
//    @GetMapping("/getUpdates")
//    ResponseEntity<ResultBotTelegramList> getUpdates1(@Param("my_header") String header);

    //retorno com Response Entity
    @PostMapping("/sendMessage")
    ResponseEntity<ResultBotTelegram> sendMessage(@RequestBody MessageSend msg);

    //retorno response Object
//    @PostMapping("/sendMessage")
//    @ResponseBody
//    ResultBotTelegram sendMessage1(@RequestBody MessageSend msg);
//
//    //set header RequestHeader
//    @PostMapping(value = "/sendMessage")
//    ResultBotTelegram sendMessage2(@RequestBody MessageSend msg, @RequestHeader("MY_HEADER") String header);

    //RequestMapping informando o tipo de metodo
//    @RequestMapping(method = RequestMethod.POST, value = "/sendMessage")
//    ResultBotTelegram sendMessage3(@RequestBody MessageSend msg);

    //Exemplo de path variable
//    @GetMapping("/getUpdates/{my_test}")
//    ResultBotTelegram examplePathVariable(@PathVariable("my_test") String myTest);

    //Exemplo de request param
    //www.minhaUrl.com.br/getUpdates?nome=nomeInformado
//    @GetMapping("/getUpdates")
//    ResultBotTelegram exampleResquestParam(@RequestParam("nome") String nome);

}
