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

	@Bean
	Document setDocument() {
		return getDocument();
	}

	//TODO Сделать refresh
	//@Async
	//@Scheduled(fixedRate = 1, timeUnit = TimeUnit.HOURS)
	private void refreshDocument(Document document) {
		document = getDocument();
	}

	@SneakyThrows
	private Document getDocument() {
		return Jsoup.connect(RequestTemplate.REQUEST.getRequest()).get();
	}
}
