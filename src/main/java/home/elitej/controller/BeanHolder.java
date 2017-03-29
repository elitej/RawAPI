package home.elitej.controller;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class BeanHolder {
    private final Map<String, Object> beans = new ConcurrentHashMap<>();

    BeanHolder(Set<>) {
    }

    Object geyBean(String fullName) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        if (beans.containsKey(fullName)) {
            return beans.get(fullName);
        } else {
            Object bean = createBean(fullName);
            beans.putIfAbsent(fullName, bean);
        }
    }

    private Object createBean(String fullName) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> beanClass = Class.forName(fullName);
        Object bean = beanClass.newInstance();
        return bean;
    }
}
