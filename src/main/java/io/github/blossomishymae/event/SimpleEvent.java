package io.github.blossomishymae.event;

/**
 * A strongly-typed base event class used for notifications with {@link SimpleEventAggregator}.
 * @param <T> the data type of the {@link SimpleEventHandler} argument.
 */
public class SimpleEvent<T> extends SimpleEventHandler<T> { }
