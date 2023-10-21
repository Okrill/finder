package ru.admhmao.handler.impl;

import static java.util.stream.Collectors.joining;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;

import ru.admhmao.bpp.annotation.CommandHandlerMethod;
import ru.admhmao.commands.Command;
import ru.admhmao.handler.CommandHandler;
import ru.admhmao.model.Card;
import ru.admhmao.parser.CardParser;
import ru.admhmao.parser.CommandParser;
import ru.admhmao.templates.AnswerTemplate;

/**
 * Handler class for command that use {@link CallbackQuery} as argument
 */
@Component
public class FindHandler implements CommandHandler {

	@Autowired
	private AnswerTemplate answerTemplate;

	@Autowired
	private CommandParser commandParser;

	@Autowired
	private CardParser cardParser;

	@Autowired
	private Document document;

	/**
	 * Message handler that invoke after {@link Command.CONTACTS}
	 */
	@CommandHandlerMethod(Command.CONTACTS)
	private SendMessage findByContacts(Message message) {
		String contacts = commandParser.getTextFromMessageWithoutCommand(message);
		return select(message, contacts, "div.fields");
	}

	/**
	 * Message handler that invoke after {@link Command.FIO}
	 */
	@CommandHandlerMethod(Command.FIO)
	private SendMessage findByFio(Message message) {
		String fio = commandParser.getTextFromMessageWithoutCommand(message);
		return select(message, fio, "div.fio");
	}

	/**
	 * Message handler that invoke after {@link Command.POST}
	 */
	@CommandHandlerMethod(Command.POST)
	private SendMessage findByPost(Message message) {
		String post = commandParser.getTextFromMessageWithoutCommand(message);
		return select(message, post, "div.post");
	}

	private SendMessage select(Message message, String findPart, String block) {
		Deque<Card> results = new ArrayDeque<>();
		Pattern p = Pattern.compile("(?iu)(" + findPart + ")");
		Elements employees = document.select(block);

		for (Element employee : employees) {
			Matcher m = p.matcher(employee.text());

			if (m.find()) {
				if (results.size() > 10) break;
				Card card = cardParser.createCard(employee);
				results.add(card);
			}
		}

		if (results.isEmpty()) {
			return answerTemplate
				.getMessage(message, "По запросу \"" + findPart + "\" - ничего не найдено");
		}
		return answerTemplate
			.getMessage(message, results.stream()
				.map(Card::toString)
				.collect(joining()));
	}
}
