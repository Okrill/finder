package ru.admhmao.bot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.api.objects.Update;

import lombok.extern.slf4j.Slf4j;
import ru.admhmao.routers.MessageRouter;
import ru.admhmao.templates.AnswerTemplate;

/*
 * Bot that route updates
 */
@Component
@Slf4j
public class Bot extends BotProperties {

	@Autowired
	private MessageRouter messageRouter;

	@Autowired
	private AnswerTemplate defaultAnswerSender;

	public Bot(SetWebhook setWebhook) {
		super(setWebhook);
	}

	@Override
	public BotApiMethod<?> onWebhookUpdateReceived(Update update) {

		try {
			return routeUpdate(update);
		} catch (Exception e) {
			log.error("ERROR:", e);
			return null;
		}
	}

	private BotApiMethod<?> routeUpdate(Update update) {

		if (update.hasMessage()) {
			return messageRouter.messageRoute(update);
		}
		return defaultAnswerSender.getMessage(update.getMessage(), "/help - список команд");
	}
}
