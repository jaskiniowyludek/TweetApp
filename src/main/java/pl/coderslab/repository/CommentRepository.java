package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.entity.Comment;
import pl.coderslab.entity.Tweet;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    List<Comment> findAllByTweetOrderByDateDesc(Tweet tweet);
    @Query("select c from Comment c where c.tweet.id=?1")
    List<Comment> findAllByTweetIdOrderByDateDesc(int id);
    int countAllByTweet(Tweet tweet);
}
