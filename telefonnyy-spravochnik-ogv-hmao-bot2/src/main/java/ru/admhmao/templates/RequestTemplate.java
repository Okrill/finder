package ru.admhmao.templates;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RequestTemplate {

	REQUEST("https://admhmao.ru/organy-vlasti/telefonnyy-spravochnik-ogv-hmao/");

	private final String request;
}
