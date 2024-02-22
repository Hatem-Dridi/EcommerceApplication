package isi.tn.service;
import isi.tn.entities.User;

import java.util.List;

public interface IuserService {
    User updateUser(Long userId, User user);
    User getUserById(Long userId);

    User saveUser(User user);
    public void deleteUser(Long userId);

    List<User> findAllUsers();

    User patchUser(Long userId, User user);

}

