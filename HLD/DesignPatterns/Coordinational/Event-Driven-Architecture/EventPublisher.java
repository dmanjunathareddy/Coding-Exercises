package com.softgroup.hld.coordination.designpatterns.eda;

import java.util.ArrayList;
import java.util.List;

public class EventPublisher {
    private List<EventListener> listeners = new ArrayList<>();

    public void addListener(EventListener listener) {
        listeners.add(listener);
    }

    public void removeListener(EventListener listener) {
        listeners.remove(listener);
    }

    public void notifyListeners(String event) {
        for (EventListener listener : listeners) {
            listener.onEvent(event);
        }
    }
}