package ru.admhmao.handler.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import ru.admhmao.bpp.annotation.CommandHandlerMethod;
import ru.admhmao.commands.Command;
import ru.admhmao.handler.CommandHandler;
import ru.admhmao.templates.AnswerTemplate;

@Component
public class ErrorsHandler implements CommandHandler {

	@Autowired
	private AnswerTemplate answerTemplate;

	/**
	 * Handler for {@link Command.ERROR}
	 */
	@CommandHandlerMethod(Command.ERROR)
	private SendMessage handleError(Message message) {
		return answerTemplate.getMessage(message, "Неправильно осуществлен поиск\n"
			+ "Пример поиска по имени:\n"
			+ "/fio уткин\n");
	}
}
