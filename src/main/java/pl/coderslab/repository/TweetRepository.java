package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;

import java.util.List;

public interface TweetRepository extends JpaRepository<Tweet,Integer> {

    List<Tweet> findAllByUserOrderByDateDesc(User user);
//    @Query("select t from Tweet t JOIN User  u ON Tweet.user.id=User.id where u.id=?1")
//    List<Tweet> findAllByUserId(int id);
    List<Tweet> findAllByOrderByDateDesc();
}
