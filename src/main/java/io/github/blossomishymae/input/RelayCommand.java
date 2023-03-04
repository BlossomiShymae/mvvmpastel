package io.github.blossomishymae.input;

import io.github.blossomishymae.event.SimpleEventHandler;

import java.util.concurrent.Callable;
import java.util.function.BooleanSupplier;

public class RelayCommand implements IRelayCommand {
    private final Callable<Void> action;
    private final BooleanSupplier canExecuteSupplier;
    public SimpleEventHandler<Boolean> executeChanged;

    public RelayCommand(Callable<Void> action) {
        this.action = action;
        canExecuteSupplier = null;
        registerCanExecuteChanged(new SimpleEventHandler<>());
    }

    public RelayCommand(Callable<Void> action, BooleanSupplier canExecute) {
        this.action = action;
        canExecuteSupplier = canExecute;
        registerCanExecuteChanged(new SimpleEventHandler<>());
    }

    public Void execute() throws Exception {
        return action.call();
    }

    @Override
    public boolean canExecute() {
        boolean canExecute = true;
        if (canExecuteSupplier != null) canExecute = canExecuteSupplier.getAsBoolean();
        return canExecute;
    }

    @Override
    public void registerCanExecuteChanged(SimpleEventHandler<Boolean> canExecuteChanged) {
        this.executeChanged = canExecuteChanged;
    }

    @Override
    public void notifyCanExecuteChanged(Boolean canExecute) {
        executeChanged.invoke(canExecute);
    }
}
