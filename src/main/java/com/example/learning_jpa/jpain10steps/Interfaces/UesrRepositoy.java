package com.example.learning_jpa.jpain10steps.Interfaces;

import com.example.learning_jpa.jpain10steps.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UesrRepositoy extends JpaRepository <User , Long > {

}
