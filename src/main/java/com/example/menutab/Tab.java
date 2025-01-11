package com.example.menutab;

public class Tab {
    private String id;
    private String title;
    private String content;
    private boolean active;

    public Tab(String id, String title, String content, boolean active) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.active = active;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public boolean isActive() {
        return active;
    }
}