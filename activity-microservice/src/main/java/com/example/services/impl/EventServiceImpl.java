package com.example.services.impl;

import com.example.command.EventCommand;
import com.example.model.Event;
import com.example.repository.EventRepository;
import com.example.services.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("eventService")
public class EventServiceImpl implements EventService {
    @Autowired
    EventRepository eventRepository;
    private static final Logger logger = LoggerFactory.getLogger(EventServiceImpl.class);

    public Event saveEvent(Event event) {
        eventRepository.save(event);
        return event;
    }

    public void deleteEvent(String eventUuid) {
        eventRepository.deleteEventByUuid(eventUuid);
    }

    public void updateEvent(EventCommand eventCommand) {
        Event event = eventRepository.findByUuid(eventCommand.getUuid());
        event = eventCommand.populateForUpdate(event);
        eventRepository.save(event);
    }
}
