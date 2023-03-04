package io.github.blossomishymae.componentmodel;

import io.github.blossomishymae.event.SimpleEventHandler;

/**
 * A base class for objects that are observable. Can be used for objects that need
 * to prop property change notifications.
 *
 * @see io.github.blossomishymae.componentmodel.INotifyPropertyChanged
 */
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
