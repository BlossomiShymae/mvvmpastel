package io.github.blossomishymae.input;

import io.github.blossomishymae.event.SimpleEventHandler;

public interface IRelayCommand<T> extends INotifyCanExecuteChanged {
    boolean canExecute(T parameter);
}
