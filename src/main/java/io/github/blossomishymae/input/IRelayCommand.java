package io.github.blossomishymae.input;

/**
 * An interface used for implementing repeating functionality behavior.
 * <p></p>
 * The non-generic counterpart of {@link IConveyCommand}.
 */
public interface IRelayCommand extends INotifyCanExecuteChanged {
    /**
     * Execute the stored procedure.
     */
    void execute();

    /**
     * Validate the stored predicate. Command can not execute when the predicate fails.
     * @return
     */
    boolean canExecute();
}
