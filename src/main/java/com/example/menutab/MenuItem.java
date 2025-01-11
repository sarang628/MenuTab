package com.example.menutab;

public class MenuItem {
    private String name;
    private String url;
    private boolean active;

    public MenuItem(String name, String url, boolean active) {
        this.name = name;
        this.url = url;
        this.active = active;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public boolean isActive() {
        return active;
    }
}
