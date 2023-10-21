package ru.admhmao.bpp.annotation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import ru.admhmao.commands.Command;

/**
 * Marks a command method that will run when it is executed.
 */
@Retention(RUNTIME)
@Target(ElementType.METHOD)
public @interface CommandHandlerMethod {
	Command value();
}
