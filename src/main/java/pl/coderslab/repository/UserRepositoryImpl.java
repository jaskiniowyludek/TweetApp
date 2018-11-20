package pl.coderslab.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
@Repository
@Transactional
public class UserRepositoryImpl implements UserRepoCustom {

    @PersistenceContext
    EntityManager entityManager;
    @Override
    public User myCustomFindById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void changeUsername(String username, int id) {
        Query q	=	entityManager
                .createQuery("Update	User u set u.username	=:username where u.id=:id");
        q.setParameter("username", username)
                .setParameter("id",id)
                .executeUpdate();
    }

    @Override
    public void changeEmail(String email, int id) {
        Query q	=	entityManager
                .createQuery("Update	User u set u.email	=:email where u.id=:id");
        q.setParameter("email", email)
                .setParameter("id",id)
                .executeUpdate();
    }

    @Override
    public void changePassword(String password, int id) {
        Query q	=	entityManager
                .createQuery("Update	User u set u.password	=:password where u.id=:id");
        q.setParameter("password", password)
                .setParameter("id",id)
                .executeUpdate();
    }
}
