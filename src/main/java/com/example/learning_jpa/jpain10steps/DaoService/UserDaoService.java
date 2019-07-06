package com.example.learning_jpa.jpain10steps.DaoService;

import com.example.learning_jpa.jpain10steps.entity.User;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class UserDaoService{

    @PersistenceContext
    private EntityManager entityManager;

    public long insert(User user) {
//Open Transaction
        entityManager.persist( user );

        return user.getId();
    }

    public List <User> findAll() {
        List<User>  user = new ArrayList <>();
        return  user;
    }

}
