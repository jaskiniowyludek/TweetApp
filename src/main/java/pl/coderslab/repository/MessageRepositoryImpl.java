package pl.coderslab.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Message;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
@Transactional
public class MessageRepositoryImpl implements MessageRepoCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Message myCustomFindById(int id) {
        return entityManager.find(Message.class, id);
    }

    @Override
    public void changeReaded(boolean readed, int id) {
        Query q	=	entityManager
                .createQuery("Update	Message m set m.readed	=:readed where m.id=:id");
        q.setParameter("readed", readed)
                .setParameter("id",id)
                .executeUpdate();
    }
}
