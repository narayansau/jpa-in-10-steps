package com.example.learning_jpa.jpain10steps.DaoService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

        @ResponseStatus(HttpStatus.NOT_FOUND)
        public class UserNotFoundException extends RuntimeException {
            public UserNotFoundException(String  p0) {
                super(p0);
            }
        }


