package io.github.blossomishymae.input;

import io.github.blossomishymae.event.SimpleEventHandler;

/**
 * An interface used for implementing can execute changed notifications.
 */
public interface INotifyCanExecuteChanged {
    /**
     * Register a simple event handler that uses {@link Boolean}.
     * @param canExecuteChanged
     */
    void registerCanExecuteChanged(SimpleEventHandler<Boolean> canExecuteChanged);

    /**
     * Notify any delegates of the simple event handler using {@link Boolean}.
     * @param canExecute
     */
    void notifyCanExecuteChanged(Boolean canExecute);
}
