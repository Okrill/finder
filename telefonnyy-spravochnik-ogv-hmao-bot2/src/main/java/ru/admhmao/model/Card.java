package ru.admhmao.model;

import java.util.List;

import lombok.Data;

@Data
public class Card {

	private String name;

	private String post;

	private List<String> contacts;

	private List<String> departments;

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("➖➖➖➖➖➖➖➖")
			.append("\n💵Место работы:\n");

		for (int i = departments.size() - 1; i > -1; i--) {
			sb.append(departments.get(i) + ", ");
		}
		sb.delete(sb.length() - 2, sb.length());
		sb.append("\n\n")
			.append("ℹ️ФИО: ")
			.append(name)
			.append("\n")
			.append("✅Должность: ")
			.append(post)
			.append("\n\n")
			.append("☎️Контакты: \n");

		for (String contact : contacts) {
			sb.append(contact + "\n");
		}
		sb.append("\n\n");
		return sb.toString();
	}
}
