package io.github.blossomishymae.event;

import java.util.HashMap;

public class SimpleEventAggregator {
    private final HashMap<Class<? extends SimpleEventHandler<?>>, SimpleEventHandler<?>> eventHashMap = new HashMap<>();

    @SuppressWarnings("unchecked")
    public <T> SimpleEventHandler<T> getEvent(Class<? extends SimpleEventHandler<T>> event) {
        if (!eventHashMap.containsKey(event)) {
            try {
                eventHashMap.put(event, event.getDeclaredConstructor().newInstance());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return (SimpleEventHandler<T>) eventHashMap.get(event);
    }
}
