package com.example.learning_jpa.jpain10steps.DaoService;

import com.example.learning_jpa.jpain10steps.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.learning_jpa.jpain10steps.Interfaces.UesrRepositoy;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserJPAResources{

@Autowired
private UserDaoService userDaoService;

@Autowired
private UesrRepositoy uesrRepositoy;

@GetMapping("/jpa/users")
public List<User> retrieveAllUsers() {
    return uesrRepositoy.findAll();
}

    @GetMapping("/jpa/user/{id}")

    public Optional <User> retrieveUser(@PathVariable int id) {

        Optional <User> userWithIdOne = uesrRepositoy.findById( (long) id );
        if ( ! userWithIdOne.isPresent())
            throw new UserNotFoundException("USer with id : " + id  + " Not Present");

        return  userWithIdOne;

    }

    @DeleteMapping("/jpa/users/{id}")
    public Optional <User> deleteUser(@PathVariable long id) {
        uesrRepositoy.deleteById( id );

        return null;
    }
@PostMapping("/jpa/users")
public ResponseEntity <Object> createUser(@Valid @RequestBody User user) {
    User savedUser = uesrRepositoy.save( user );

    URI location =ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path( "/{id}" )
            .buildAndExpand( savedUser.getId() )
            .toUri();
    return  ResponseEntity.created( location ).build();
}

        @PersistenceContext
        private EntityManager entityManager;

        public long insert(User user) {
//Open Transaction
            entityManager.persist( user );

            return user.getId();
        }

    }

