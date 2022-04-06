package hiber.dao;

import hiber.models.User;

import javax.persistence.TypedQuery;
import java.util.List;

public interface UserDao {

    void add(User user);

    void delete(int id);

    User get(int id);

    List<User> listUsers();

    void set(int id, User newUser);
}
