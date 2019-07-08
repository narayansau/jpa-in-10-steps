package com.example.learning_jpa.jpain10steps.entity;

//Tab;e - user

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.catalina.LifecycleState;

import java.util.List;

@ApiModel(description="All Details about the user")
@Entity
public class User{
    @Id
    @GeneratedValue
    private long id;

    @Size( min=2, message="The Name should have atleast two characters")
    @ApiModelProperty(notes="Name must have more than One charachetr")
    private String name;
    private String role;

   // @OneToMany(mappedBy="user")
   // private List <Post> posts;

    public User(String name, String role) {
        super();
        this.name=name;
        this.role=role;
    }

    public User() {
        super();
    }

    public User(long id, String name, String role) {

        this.id=id;
        this.name=name;
        this.role=role;
    }
/******************************
    public User(@Size(min=2, message="The Name should have atleast two characters") String name, String role,
                //List <Post> posts
                ) {
        this.name=name;
        this.role=role;
      //  this.posts=posts;
    }
*********************/
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role=role;
    }

   // public List <Post> getPosts() {
  //      return posts;
  //  }

   // public void setPosts(List <Post> posts) {
     //   this.posts=posts;
   // }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                // ",    posts=" + posts +
                '}';
    }
}
