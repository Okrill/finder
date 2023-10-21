package ru.admhmao.templates;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
public class AnswerTemplate {

	public SendMessage getMessage(Message message, String textMessage) {
		return SendMessage.builder()
			.text(textMessage)
			.chatId(message.getChatId())
			.build();
	}
}
