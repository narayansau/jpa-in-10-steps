package com.example.learning_jpa.jpain10steps.DaoService;

import com.example.learning_jpa.jpain10steps.entity.User;

import com.example.learning_jpa.jpain10steps.DaoService.UserDaoService;
import com.example.learning_jpa.jpain10steps.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RestController
public class UserJPAResources{

@Autowired
private UserDaoService userDaoService;

@GetMapping("/users")
public List<User> retrieveAllUsers() {
    return userDaoService.findAll();
}

    @GetMapping("/user/{id}")
    public Resources < User > retrieveUser(@PathVariable int id) {
    public  User findOne(long id) {

        boolean found = true;
        for ( User user: users) {
            if ( user.getId() == id)
                return user;
            else
                found = false;
        }
        if ( ! found )
            throw new UserNotFoundException(  "id = " + id );
        return null;

    }


        @PersistenceContext
        private EntityManager entityManager;

        public long insert(User user) {
//Open Transaction
            entityManager.persist( user );

            return user.getId();
        }

    }

