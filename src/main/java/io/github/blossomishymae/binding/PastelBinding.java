package io.github.blossomishymae.binding;

import io.github.blossomishymae.componentmodel.ObservableObject;
import io.github.blossomishymae.componentmodel.PropertyChangedEventArgs;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * A strongly-typed binding class that ties a {@link ObservableObject} with its source
 * {@link Supplier} to a control {@link Consumer}. Binding will be used on every {@link io.github.blossomishymae.componentmodel.INotifyPropertyChanged INotifyPropertyChanged}
 * event.
 *
 * @param <T> the data type used for passing an object from {@link Supplier} to {@link Consumer}.
 * @see ObservableObject
 * @see io.github.blossomishymae.componentmodel.INotifyPropertyChanged INotifyPropertyChanged
 */
public class PastelBinding<T> implements IPastelBinding<T> {
    private final Supplier<T> dataSupplier;
    private final Consumer<T> controlConsumer;
    private final ArrayList<Predicate<T>> predicateArrayList = new ArrayList<>();

    public PastelBinding(ObservableObject observableObject, Supplier<T> dataSupplier, Consumer<T> controlConsumer) {
        this.dataSupplier = dataSupplier;
        this.controlConsumer = controlConsumer;
        observableObject.propertyChanged.subscribe(this::onPropertyChanged);
    }

    @Override
    public void onPropertyChanged(PropertyChangedEventArgs e) {
        var data = dataSupplier.get();
        var isValid = true;
        for (var predicate : predicateArrayList) {
            if (!predicate.test(data))  {
                isValid = false;
                break;
            }
        }
        if (isValid) {
            controlConsumer.accept(data);
        }
    }

    public void addPredicate(Predicate<T> predicate) {
        predicateArrayList.add(predicate);
    }

    public void clearPredicates() {
        predicateArrayList.clear();
    }
}
