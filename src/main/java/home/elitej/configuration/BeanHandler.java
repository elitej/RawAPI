package home.elitej.configuration;

import home.elitej.configuration.handler.AnnotationHandler;
import home.elitej.configuration.handler.InjectAnnotationHandler;

import java.util.*;

public class BeanHandler implements AnnotationHandler {
    private final BeanHolder controllerHolder;
    private final List<AnnotationHandler> handlers;


    public BeanHandler(BeanHolder controllerHolder) {
        this.controllerHolder = controllerHolder;
        this.handlers = initHandlers();
    }

    @Override
    public void handle(Object o){
        for (AnnotationHandler handler : handlers) {
            handler.handle(o);
        }
    }

    private List<AnnotationHandler> initHandlers() {
        ArrayList<AnnotationHandler> result = new ArrayList<>();
        InjectAnnotationHandler injectAnnotationHandler = new InjectAnnotationHandler(controllerHolder.getBeans());
        result.add(injectAnnotationHandler);
        return result;
    }

}
