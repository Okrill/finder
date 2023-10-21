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
public class StartHandler implements CommandHandler {

	@Autowired
	private AnswerTemplate answerTemplate;
	// TODO заполнить все возможные команды в боте

	/**
	 * Handler for {@link Command.START}
	 */
	@CommandHandlerMethod(Command.START)
	private SendMessage handleStart(Message message) {
		return answerTemplate.getMessage(message, "Воспользуйтесь командами");
	}
}
