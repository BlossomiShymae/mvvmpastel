package io.github.blossomishymae.binding;

import io.github.blossomishymae.componentmodel.PropertyChangedEventArgs;

import java.util.function.Predicate;

/**
 * An interface used for implementing data binding behavior.
 * @param <T> the data type used for validating with predicates.
 */
public interface IPastelBinding<T> {
    /**
     * Process binding behavior on an object with {@link io.github.blossomishymae.componentmodel.INotifyPropertyChanged INotifyPropertyChanged}.
     * @param e
     */
    void onPropertyChanged(PropertyChangedEventArgs e);

    /**
     * Add a predicate used for binding validation. If a predicate returns false, the binding will
     * fail-fast with no source transmission.
     * @param predicate
     */
    void addPredicate(Predicate<T> predicate);

    /**
     * Clear all stored predicates.
     */
    void clearPredicates();
}
