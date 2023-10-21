package ru.admhmao.configuration;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;

import lombok.SneakyThrows;
import ru.admhmao.templates.RequestTemplate;

@Configuration
@EnableAsync
@EnableScheduling
public class AppConfiguration {

	@Bean
	SetWebhook setWebhook() {
		return new SetWebhook();
	}

}
