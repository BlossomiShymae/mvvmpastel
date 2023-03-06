package io.github.blossomishymae.swing;

import javax.swing.*;

/**
 * A view model class that represents the information of a page.
 */
public class PageNavigation {
    private final String title;
    private final Class<? extends JPanel> pageKey;

    public PageNavigation(String title, Class<? extends JPanel> pageKey) {
        this.title = title;
        this.pageKey = pageKey;
    }

    public String getTitle() {
        return title;
    }

    public Class<? extends JPanel> getPageKey() {
        return pageKey;
    }
}
