package ru.admhmao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

import ru.admhmao.bot.Bot;

@RestController("/")
public class Controller {

	@Autowired
	private Bot bot;

	@PostMapping
	public BotApiMethod<?> onUpdateReceived(@RequestBody Update update) {
		return bot.onWebhookUpdateReceived(update);
	}
}
