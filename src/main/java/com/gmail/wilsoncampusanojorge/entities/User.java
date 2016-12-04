package com.gmail.wilsoncampusanojorge.entities;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String username;
  private String password;


}
