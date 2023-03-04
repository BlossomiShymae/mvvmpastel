package io.github.blossomishymae.event;

import java.util.ArrayList;

/**
 * A strongly-typed event handler class used to send data to subscribed objects. Only an
 * <i>args</i> data object is sent for an event.
 * <p></p>
 * Styled after .NET event handlers.
 *
 * @param <T> the data type of the <i>args</i> for sending to subscriptions.
 */
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
