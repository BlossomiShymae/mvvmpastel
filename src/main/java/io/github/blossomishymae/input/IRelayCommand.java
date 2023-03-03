package io.github.blossomishymae.input;

import io.github.blossomishymae.event.SimpleEventHandler;

public interface IRelayCommand<T> {
    boolean canExecute(T parameter);
    void registerCanExecuteChanged(SimpleEventHandler<Boolean> canExecuteChanged);
    void notifyCanExecuteChanged(Boolean canExecute);
}
