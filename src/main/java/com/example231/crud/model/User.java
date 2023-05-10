package com.example231.crud.model;


import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue()
    private Long id;
    private String name;
    private String age;
    private String email;

    public User(String name, String age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public User(){

    }

    public void setId(Long id) {this.id = id;}
    public Long getId(){return id;}

    public void setName(String name) {this.name = name;}
    public String getName() {return name;}

    public void setAge(String age) {this.age = age;}
    public String getAge() {return age;}

    public void setEmail(String email) {this.email = email;}
    public String getEmail() {return email;}

}
