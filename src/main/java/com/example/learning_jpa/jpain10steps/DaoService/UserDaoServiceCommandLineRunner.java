package com.example.learning_jpa.jpain10steps.DaoService;



import com.example.learning_jpa.jpain10steps.Interfaces.UesrRepositoy;
import com.example.learning_jpa.jpain10steps.entity.User;
//import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("ALL")
@Service
public class UserDaoServiceCommandLineRunner implements
        CommandLineRunner{

    private static final Logger log =
           LoggerFactory
            .getLogger( UserDaoServiceCommandLineRunner.class );
@Autowired
    private UserDaoService uerDaoService;

    @Autowired
private UesrRepositoy userRepository;

    @Override
    public void run(String... args) throws Exception {
        User user = new User("Jack" , "Admin");

       long inrt = uerDaoService.insert( user );
        System.out.println( " After creation ID is : " + inrt );
        log.info( "New User Created : " + user );
        user = new User();
          user.setName( "Narayan" );
          user.setRole( "Programmer " );

        User inrts = userRepository.save( user );

        inrts = userRepository.save( new User("Ratan" , "System Analyst") );
        System.out.println( " After creation ID is : " + inrts );
        log.info( "New User Created : " + user );

       Optional<User> userWithIdOne = userRepository.findById( 1L );
        log.info( " User Retrieve: " + userWithIdOne );

        List<User> users = userRepository.findAll();

        log.info( " All User Retrieve: " + users );
    }
}
