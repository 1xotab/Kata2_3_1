package hiber.dao;

import hiber.models.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void delete(int id) {
        User user = get(id);
        entityManager.remove(entityManager.contains(user) ? user : entityManager.merge(user));
    }

    @Override
    public User get(int id) {

        User user = entityManager.find(User.class, id);
        entityManager.detach(user);
        return user;
    }


    @Override
    public void set(int id, User newUser) {

        User user = get(id);
        user.setName(newUser.getName());
        user.setLastName(newUser.getLastName());
        entityManager.merge(user);
    }

    @Override
    public List<User> listUsers() {
        TypedQuery<User> query = entityManager.createQuery("from User", User.class);
        return query.getResultList();
    }
}
