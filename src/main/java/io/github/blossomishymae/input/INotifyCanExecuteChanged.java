package io.github.blossomishymae.input;

import io.github.blossomishymae.event.SimpleEventHandler;

public interface INotifyCanExecuteChanged {
    void registerCanExecuteChanged(SimpleEventHandler<Boolean> canExecuteChanged);
    void notifyCanExecuteChanged(Boolean canExecute);
}
