package ru.admhmao.bpp;

import java.lang.reflect.Method;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import ru.admhmao.bpp.annotation.CommandHandlerMethod;
import ru.admhmao.commands.Command;
import ru.admhmao.exception.CommandConflictException;
import ru.admhmao.handler.HandlerDefenitionStore;
import ru.admhmao.model.HandlerDefenition;

/**
 * BPP for map {@link HandlerDefenition} to {@link CommandHandlerMethod} in
 * {@link HandlerDefenitionStore}
 */
@Component
public class HandlerInjectorBPP implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) {
		Method[] methods = bean.getClass().getDeclaredMethods();
		for (Method method : methods) {
			CommandHandlerMethod commandAnnotation = method.getAnnotation(CommandHandlerMethod.class);
			if (commandAnnotation != null) {
				Command command = commandAnnotation.value();
				if (HandlerDefenitionStore.isNotPresent(command)) {
					HandlerDefenitionStore.put(command, beanName, method);
				} else {
					throw new CommandConflictException("Command '" + command + "' not obvious for injection");
				}
			}
		}
		return bean;
	}
}
