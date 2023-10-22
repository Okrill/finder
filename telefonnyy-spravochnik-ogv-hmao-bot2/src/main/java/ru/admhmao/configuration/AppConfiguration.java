package ru.admhmao.configuration;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;

import lombok.SneakyThrows;

@Configuration
@EnableAsync
@EnableScheduling
public class AppConfiguration {

	@Bean
	SetWebhook setWebhook() {
		return new SetWebhook();
	}

	@Bean
	@SneakyThrows
	Document setDocument() {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("html.txt").getFile());
		String data = FileUtils.readFileToString(file, "UTF-8");
		Document document = Jsoup.parse(data);
		return document;
	}
}
