package io.github.blossomishymae.componentmodel;

/**
 * An event data class used to contain data for a property changed event.
 *
 * @see io.github.blossomishymae.componentmodel.INotifyPropertyChanged
 */
public class PropertyChangedEventArgs {
    public final String callerName;

    public PropertyChangedEventArgs(String callerName) {
        this.callerName = callerName;
    }
}
