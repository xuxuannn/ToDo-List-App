package com.example.todolist;

public class Task {
    private String title;
    private String description;
    private String category;
    private String status;

    public Task(String title, String description, String category,String status) {
        this.title = title;
        this.description = description;
        this.category= category;
        this.status = status;
    }

    // Override the toString method to return the title of the task
    @Override
    public String toString() {
        return "Title: " + title + "\nDescription: " + description + "\n\nCategory:" + category + "\nStatus: " + status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

