package com.example.menutab.model;

import java.util.ArrayList;
import java.util.List;

public class MenuItem {
    private final int id;
    private final String name;
    private final String url;
    private MenuItem parentMenu;
    private final List<MenuItem> children = new ArrayList<>();

    public MenuItem(int id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }

    public MenuItem getParentMenu() {
        return parentMenu;
    }

    public void setParentMenu(MenuItem parentMenu) {
        this.parentMenu = parentMenu;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public int getId() {
        return id;
    }

    public List<MenuItem> getChildren() {
        return children;
    }

    public void addChildren(MenuItem menuItem) {
        this.children.add(menuItem);
    }
}
