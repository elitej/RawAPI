package home.elitej.configuration.handler;

import home.elitej.annotation.Inject;
import home.elitej.exception.InjectHandlerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class InjectAnnotationHandler implements AnnotationHandler {
    private final Map<Object, Set<Class>> beans;

    public InjectAnnotationHandler(Map<Object, Set<Class>> beans) {
        this.beans = beans;
    }

    @Override
    public void handle(Object bean) {
        processField(bean);
    }

    private void processField(Object bean) {
        Class<?> clazz = bean.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Inject.class)) {
                Class<?> fieldType = field.getType();
                List<Object> suitableBean = findSuitableBean(fieldType);
                if (suitableBean.size() != 1) {
                    throw new InjectHandlerException("found more than one the suitable bean");
                }
                setValueToField(field, bean, suitableBean.get(0));

            }
        }
    }

    private void setValueToField(Field field, Object bean, Object value) {
        try {
            field.setAccessible(true);
            field.set(bean, value);
            field.setAccessible(false);
        } catch (IllegalAccessException e) {
            throw new InjectHandlerException("Setting the value failed. Access to field denied", e);
        }

    }

    private List<Object> findSuitableBean(Class cl) {
        List<Object> result = new LinkedList<>();
        for (Map.Entry<Object, Set<Class>> entry : beans.entrySet()) {
            if (entry.getValue().contains(cl)) {
                result.add(entry.getKey());
            }
        }
        return result;
    }


}
