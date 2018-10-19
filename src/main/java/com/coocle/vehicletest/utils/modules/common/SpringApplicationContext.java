package com.coocle.vehicletest.utils.modules.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringApplicationContext implements ApplicationContextAware {

	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		if(SpringApplicationContext.applicationContext == null) {
			SpringApplicationContext.applicationContext = applicationContext;
		}
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public static Object getBean(String beanName) {
		return applicationContext.getBean(beanName);
	}

	public static <E> E getBean(Class<E> clazz) {
		return applicationContext.getBean(clazz);
	}

}
