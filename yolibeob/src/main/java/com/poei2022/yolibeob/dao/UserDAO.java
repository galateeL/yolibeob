package com.poei2022.yolibeob.dao;

import com.poei2022.yolibeob.dao.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDAO {
    List<User> findAll();

    boolean create(User user);

    Optional<User> findById(long idParam);

    boolean delete(long id);

    boolean edit(User userToEdit);
}
