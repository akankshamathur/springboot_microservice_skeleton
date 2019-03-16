package com.example.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "authentication")
public interface UserSearch {

    @RequestMapping(value = "/authenticate/consumer/fetchUser/{userUuid}", method = RequestMethod.GET)
    ResponseEntity<?> findByUuid(@PathVariable(value = "userUuid") String uuid);

    @RequestMapping(value = "/authenticate/auth/demo", method = RequestMethod.GET)
    String demo();
}
