package home.elitej.configuration;

import home.elitej.exception.BeanCreatingException;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class BeanHolder {
    private final Map<Object, Set<Class>> beans = new ConcurrentHashMap<>();
    private final BeanHandler handler = new BeanHandler(this);

    public BeanHolder(String filePath) {
        XmlConfigurationParser parser = new XmlConfigurationParser(filePath);
        fullyConfigure(parser);
    }

    public void tuneBean(Object bean) {
        handler.handle(bean);
    }

    Map<Object, Set<Class>> getBeans() {
        return beans;
    }

    private void fullyConfigure(XmlConfigurationParser parser) {
        createAll(parser);
        tuneBeans();
    }

    private void tuneBeans() {
        for (Object bean : beans.keySet()) {
            handler.handle(bean);
        }
    }

    private void createAll(XmlConfigurationParser parser) {
        List<String> beansInfo = parser.getBeansInfo();
        createBeans(beansInfo);
    }

    private void createBeans(List<String> beansInfo) {
        for (String bean : beansInfo) {
            Object raw = create(bean);
            Set<Class> types = getTypes(raw.getClass());
            beans.put(raw, types);
        }
    }

    private Set<Class> getTypes(Class cl) {
        Set<Class> result = new HashSet<>();
        findParents(cl, result);
        return result;
    }

    private void findParents(Class cl, Set<Class> set) {
        Class[] interfaces = cl.getInterfaces();
        set.addAll(Arrays.asList(interfaces));
        Class superclass = cl.getSuperclass();
        if (superclass.equals(Object.class))
            return;
        findParents(superclass, set);
    }

    private Object create(String fullName) {
        try {
            Class<?> clazz = Class.forName(fullName);
            return clazz.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new BeanCreatingException("bean creating failed", e);
        }
    }


}
