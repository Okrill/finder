package ru.admhmao.configuration;

import static java.util.stream.Collectors.joining;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

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
		Path path = Path.of("src", "main", "resources", "html.txt");
		String data = Files.readAllLines(path, StandardCharsets.UTF_8)
			.stream()
			.collect(joining("\n"));
		Document document = Jsoup.parse(data);
		return document;
	}
}
