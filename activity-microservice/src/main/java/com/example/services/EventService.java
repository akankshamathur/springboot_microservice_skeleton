package com.example.services;

import com.example.command.EventCommand;
import com.example.model.Event;

public interface EventService {
    Event saveEvent(Event event);

    void deleteEvent(String uuid);

    void updateEvent(EventCommand eventCommand);
}
