package io.github.blossomishymae.input;

public interface IConveyCommand<T> extends INotifyCanExecuteChanged {
    boolean canExecute(T parameter);
}
