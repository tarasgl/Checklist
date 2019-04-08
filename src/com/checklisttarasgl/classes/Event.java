package com.checklisttarasgl.classes;

public class Event {
    private int id;
    private String name;
    private String description;
    private boolean isDone = false;

    public Event(){
        id = -1;

    }

    public Event(int id, String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Event(int id, String name, String description, boolean isDone){
        this(id,name,description);
        this.isDone = isDone;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean getIsDone() {
        return isDone;
    }
}
