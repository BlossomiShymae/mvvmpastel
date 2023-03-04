package io.github.blossomishymae.event;

import java.util.HashMap;

/**
 * An event class that acts as a single source of simple events for many objects. The default
 * return value for {@link #getEvent(Class)} is a typed {@link SimpleEventHandler}.
 *
 * @see io.github.blossomishymae.event.SimpleEventHandler
 */
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
