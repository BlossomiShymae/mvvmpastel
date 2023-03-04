package io.github.blossomishymae.input;

public interface IConveyCommand<T> extends INotifyCanExecuteChanged {
    void execute(T parameter);
    boolean canExecute(T parameter);
}
