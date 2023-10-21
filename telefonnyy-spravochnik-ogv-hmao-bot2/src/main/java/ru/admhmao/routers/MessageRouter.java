package ru.admhmao.routers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class MessageRouter {

	@Autowired
	private MessageTextRouter messageTextRouter;

	public BotApiMethod<?> messageRoute(Update update) {
		Message message = update.getMessage();
		return messageTextRouter.textRoute(message);
	}
}
