package io.github.blossomishymae.event;

import java.util.ArrayList;

public class SimpleEventHandler<T> {
    private final ArrayList<ISimpleEventSubscription<T>> subscriptions = new ArrayList<>();

    public void subscribe(ISimpleEventSubscription<T> subscription) {
        subscriptions.add(subscription);
    }

    public void invoke(T args) {
        for (var subscription: subscriptions) {
            subscription.invoke(args);
        }
    }

    public void clear() {
        subscriptions.clear();
    }
}
