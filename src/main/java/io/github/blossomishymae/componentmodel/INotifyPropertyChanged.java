package io.github.blossomishymae.componentmodel;

import io.github.blossomishymae.event.SimpleEventHandler;

public interface INotifyPropertyChanged {
    void registerPropertyChanged(SimpleEventHandler<PropertyChangedEventArgs> propertyChanged);
    void notifyPropertyChanged(String callerName);
}
