package com.gmail.wilsoncampusanojorge.entities.dao;

import com.gmail.wilsoncampusanojorge.entities.seguridad.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserDao extends CrudRepository<User, Long> {
}
