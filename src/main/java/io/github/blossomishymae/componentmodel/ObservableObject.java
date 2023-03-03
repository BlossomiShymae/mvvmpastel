package io.github.blossomishymae.componentmodel;

import io.github.blossomishymae.event.SimpleEventHandler;

public class ObservableObject implements INotifyPropertyChanged {
    public SimpleEventHandler<PropertyChangedEventArgs> propertyChanged;

    public ObservableObject() {
        registerPropertyChanged(new SimpleEventHandler<>());
    }
    @Override
    public void registerPropertyChanged(SimpleEventHandler<PropertyChangedEventArgs> propertyChanged) {
        this.propertyChanged = propertyChanged;
    }

    @Override
    public void notifyPropertyChanged(String callerName) {
        propertyChanged.invoke(new PropertyChangedEventArgs(callerName));
    }
}
