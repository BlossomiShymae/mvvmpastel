package io.github.blossomishymae.binding;

import io.github.blossomishymae.componentmodel.PropertyChangedEventArgs;

import java.util.function.Predicate;

public interface IPastelBinding<T> {
    void onPropertyChanged(PropertyChangedEventArgs e);
    void addPredicate(Predicate<T> predicate);
    void clearPredicates();
}
