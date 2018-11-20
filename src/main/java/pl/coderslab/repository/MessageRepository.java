package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.entity.Message;
import pl.coderslab.entity.User;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer>, MessageRepoCustom {

    List<Message> findAllBySenderOrderByDateDesc(User sender);
    List<Message> findAllByReceiverOrderByDateDesc(User receiver);
}
