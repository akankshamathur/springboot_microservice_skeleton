package com.kidventure.config.security.service;

import com.kidventure.model.User;
import com.kidventure.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public UserDetailServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("inside load user by username");
        User user = userRepository.findByUsername(username);
        logger.info("user???");
        logger.info(username);
        logger.info(user.getUsername());
//        logger.info(user.getUsername());
        if (user != null) {
            logger.info("inside  if");
            return user;
        } else {
            logger.info("inside else");
            throw new UsernameNotFoundException("User with username:" + username + " not found");
        }
    }
}
