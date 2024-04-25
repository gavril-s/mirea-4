package com.example.task14;

import java.time.LocalDateTime;

public class Post {
    private String text;
    private LocalDateTime creationDate;

    public Post(String text, LocalDateTime creationDate) {
        this.text = text;
        this.creationDate = creationDate;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
