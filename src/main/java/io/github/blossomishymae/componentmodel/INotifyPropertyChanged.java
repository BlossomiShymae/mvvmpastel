package io.github.blossomishymae.componentmodel;

import io.github.blossomishymae.event.SimpleEventHandler;

/**
 * An interface used for implementing property changed notifications.
 */
public interface INotifyPropertyChanged {
    /**
     * Register a simple event handler that uses {@link PropertyChangedEventArgs}.
     * @param propertyChanged
     */
    void registerPropertyChanged(SimpleEventHandler<PropertyChangedEventArgs> propertyChanged);

    /**
     * Notify any delegates of the simple event handler using {@link PropertyChangedEventArgs}.
     * @param callerName
     */
    void notifyPropertyChanged(String callerName);
}
