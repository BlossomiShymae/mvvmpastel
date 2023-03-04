package io.github.blossomishymae.input;

/**
 * An interface used for implementing repeating functionality behavior.
 * <p></p>
 * The generic counterpart of {@link IRelayCommand}.
 * @param <T> the data type used for passing objects to delegate.
 */
public interface IConveyCommand<T> extends INotifyCanExecuteChanged {
    /**
     * Execute the stored procedure with passed data parameter.
     * @param parameter
     */
    void execute(T parameter);

    /**
     * Validate the stored predicate with passed data parameter. Command can not execute when
     * the predicate fails.
     * @param parameter
     * @return
     */
    boolean canExecute(T parameter);
}
