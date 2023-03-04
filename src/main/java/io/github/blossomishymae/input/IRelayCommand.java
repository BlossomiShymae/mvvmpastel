package io.github.blossomishymae.input;

public interface IRelayCommand extends INotifyCanExecuteChanged {
    boolean canExecute();
}
