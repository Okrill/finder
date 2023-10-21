package ru.admhmao.parser;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import ru.admhmao.model.Card;

@Component
public class CardParser {

	public Card createCard(Element employee) {
		Card card = new Card();
		Element parent = employee.parent();
		Elements fields = parent.select(" > div.fields > div");
		Element post = parent.selectFirst("div.post");
		Element name = parent.selectFirst("div.fio");
		List<String> departments = new ArrayList<String>();

		while (!parent.hasClass("child")
			|| !"tree".equals(parent.parent().id())) {

			if (parent.hasClass("dep")) {
				Element dep = parent.selectFirst("span.section-title.section-title__nc");
				departments.add(dep.text());
			}
			parent = parent.parent();
		}

		List<String> contacts = new ArrayList<>();

		for (Element field : fields) {
			contacts.add(field.text());
		}
		card.setPost(post.text());
		card.setName(name.text());
		card.setDepartments(departments);
		card.setContacts(contacts);
		return card;
	}
}
