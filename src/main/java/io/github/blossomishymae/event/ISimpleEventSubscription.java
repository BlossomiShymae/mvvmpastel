package io.github.blossomishymae.event;

/**
 * An interface used for implementing delegate behavior. {@link #invoke(Object)} will be called
 * on any event from {@link SimpleEventHandler}.
 * @param <T> the data type of the received argument
 */
@FunctionalInterface
public interface ISimpleEventSubscription<T extends Object> {
    void invoke(T args);
}
