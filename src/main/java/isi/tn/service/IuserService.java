package isi.tn.service;
import isi.tn.entities.User;
public interface IuserService {
    User updateUser(Long userId, User user);
    User getUserById(Long userId);
}

