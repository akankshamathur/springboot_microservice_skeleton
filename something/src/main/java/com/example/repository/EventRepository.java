package com.example.repository;

import com.example.model.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface EventRepository extends MongoRepository<Event, String> {
    Event findByName(String name);

    Event findByUuid(String uuid);

    Page<Event> findAllByUserId(String user, Pageable pageable);

    String deleteEventByUuid(String uuid);
}
