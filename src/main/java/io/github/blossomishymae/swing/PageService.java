package io.github.blossomishymae.swing;

import javax.swing.*;
import java.util.HashMap;

/**
 * A service class used to map {@link PageNavigation} objects for use with {@link JTabbedPane}.
 */
public class PageService {
    private final HashMap<Class<? extends JPanel>, JPanel> pageHashMap = new HashMap<>();

    public void add(Class<? extends JPanel> key, JPanel page) {
        pageHashMap.put(key, page);
    }

    /**
     * Adds mapped page objects into provided {@link JTabbedPane}.
     * @param tabbedPane
     * @param pageNavigationIterable
     */
    public void useTabbedPane(JTabbedPane tabbedPane, Iterable<PageNavigation> pageNavigationIterable) {
        for (var navigation : pageNavigationIterable)  {
            tabbedPane.add(navigation.getTitle(), get(navigation.getPageKey()));
        }
    }

    private JPanel get(Class<? extends JPanel> key) {
        if (!pageHashMap.containsKey(key)) {
            throw new RuntimeException("Page does not exist. DId you forget to add it? o.o");
        }
        return pageHashMap.get(key);
    }
}
