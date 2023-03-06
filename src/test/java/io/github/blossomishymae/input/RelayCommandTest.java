package io.github.blossomishymae.input;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

class RelayCommandTest {
    @Test
    void execute_WithNoCanExecute_RunsAction() {
        AtomicInteger count = new AtomicInteger();
        var command = new RelayCommand(count::getAndIncrement);

        command.execute();

        assertEquals(1, count.get());
    }

    @Test
    void canExecute_WithNoCanExecute_IsTrue() {
        var command = new RelayCommand(() -> {});

        var canExecute = command.canExecute();

        assertTrue(canExecute);
    }

    @Test
    void execute_CanExecute_RunsAction() {
        AtomicInteger count = new AtomicInteger();
        var command = new RelayCommand(
                count::getAndIncrement,
                () -> true
        );

        command.execute();

        assertEquals(1, count.get());
    }

    @Test
    void execute_CannotExecute_DoesNothing() {
        AtomicInteger count = new AtomicInteger();
        var command = new RelayCommand(
                count::getAndIncrement,
                () -> false
        );

        command.execute();

        assertEquals(0, count.get());
    }

    @Test
    void canExecute_SupplierFails_IsFalse() {
        var command = new RelayCommand(
                () -> {},
                () -> false
        );

        var canExecute = command.canExecute();

        assertFalse(canExecute);
    }
}