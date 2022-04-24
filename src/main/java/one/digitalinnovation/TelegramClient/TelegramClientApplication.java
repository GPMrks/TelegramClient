package one.digitalinnovation.TelegramClient;

import one.digitalinnovation.TelegramClient.controller.TelegramController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TelegramClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(TelegramClientApplication.class, args);
	}


}
