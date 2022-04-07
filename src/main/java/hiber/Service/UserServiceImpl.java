package hiber.Service;

import hiber.dao.UserDaoImpl;
import hiber.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDaoImpl userDaoImpl;

    @Override
    public void add(User user) {
        userDaoImpl.add(user);
    }

    @Override
    public void delete(int id) {
        userDaoImpl.delete(id);
    }

    @Override
    public User get(int id) {
        return userDaoImpl.get(id);
    }

    @Override
    public List<User> getAllUsers(){
        return userDaoImpl.listUsers();
    }
}
