package io.github.blossomishymae.input;

import io.github.blossomishymae.event.SimpleEventHandler;

import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * A command class used to repeat its functionality to other objects by
 * invoking delegates. The default return value for {@link #canExecute(Object)} is true.
 * <p></p>
 * The generic counterpart of {@link RelayCommand}.
 *
 * @param <T> the data type used for passing objects to delegates.
 * @see io.github.blossomishymae.input.RelayCommand
 */
public class ConveyCommand<T> implements IConveyCommand<T> {
    private final Consumer<T> action;
    private final Predicate<T> canExecutePredicate;
    public SimpleEventHandler<Boolean> executeChanged;

    public ConveyCommand(Consumer<T> action) {
        this.action = action;
        canExecutePredicate = null;
        registerCanExecuteChanged(new SimpleEventHandler<>());
    }

    public ConveyCommand(Consumer<T> action, Predicate<T> canExecute) {
        this.action = action;
        canExecutePredicate = canExecute;
        registerCanExecuteChanged(new SimpleEventHandler<>());
    }

    public void execute(T parameter) {
        action.accept(parameter);
    }

    @Override
    public boolean canExecute(T parameter) {
        boolean canExecute = true;
        if (canExecutePredicate != null) canExecute = canExecutePredicate.test(parameter);
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
