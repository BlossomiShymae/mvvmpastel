package io.github.blossomishymae.event;

@FunctionalInterface
public interface ISimpleEventSubscription<T extends Object> {
    void invoke(T args);
}
