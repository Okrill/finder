package ru.admhmao.parser;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
public class CommandParser {

	public String getTextFromMessageWithoutCommand(Message message) {
		String text = message.getText();
		int commandLength = text.indexOf(' ');

		if (commandLength == -1) {
			return "ПУСТОЕ ПОЛЕ";
		}
		return text.substring(commandLength).trim();
	}
}
