package com.checklisttarasgl.classes;

import java.util.Comparator;

public class Event {
    private int id;
    private String name;
    private String description;
    private boolean isDone = false;

    public Event() {
        id = -1;
    }

    public Event(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Event(int id, String name, String description, boolean isDone) {
        this(id, name, description);
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

    public static Comparator<Event> getIdComparator(){
        return new Comparator<Event>() {
            @Override
            public int compare(Event o1, Event o2) {
                return Integer.compare(o1.id,o2.id);
            }
        };
    }

    public static Comparator<Event> getIdDescendingComparator(){
        return new Comparator<Event>() {
            @Override
            public int compare(Event o1, Event o2) {
                return Integer.compare(o2.id,o1.id);
            }
        };
    }

    public static Comparator<Event> getNameComparator(){
        return new Comparator<Event>() {
            @Override
            public int compare(Event o1, Event o2) {
                return o1.name.compareTo(o2.name);
            }
        };
    }

    public static Comparator<Event> getNameDescendingComparator(){
        return new Comparator<Event>() {
            @Override
            public int compare(Event o1, Event o2) {
                return o2.name.compareTo(o1.name);
            }
        };
    }
}
