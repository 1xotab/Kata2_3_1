package hiber.Service;

import hiber.dao.UserDaoImpl;
import hiber.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDaoImpl userDaoImpl;

    @Transactional
    @Override
    public void add(User user) {
        userDaoImpl.add(user);
    }

    @Transactional
    @Override
    public void delete(int id) {
        userDaoImpl.delete(id);
    }

    @Transactional
    @Override
    public User get(int id) {
        return userDaoImpl.get(id);
    }

    @Transactional
    @Override
    public List<User> getAllUsers(){
        return userDaoImpl.listUsers();
    }
}
