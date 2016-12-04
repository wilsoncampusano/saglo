package com.gmail.wilsoncampusanojorge.service;

import com.gmail.wilsoncampusanojorge.entities.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserDao userDao;
}
