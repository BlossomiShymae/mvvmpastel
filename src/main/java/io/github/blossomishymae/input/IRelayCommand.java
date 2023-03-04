package io.github.blossomishymae.input;

public interface IRelayCommand extends INotifyCanExecuteChanged {
    void execute();
    boolean canExecute();
}
