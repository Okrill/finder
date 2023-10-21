package ru.admhmao.commands;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Set of command
 */
@Getter
@RequiredArgsConstructor
public enum Command {

	START("/start", true),
	FIO("/fio", true),
	CONTACTS("/contacts", true),
	POST("/post", true),
	ERROR("Error", false);

	private final String name;

	private final boolean isLineCommand;
}