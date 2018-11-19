package pl.coderslab.entity;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.cglib.core.Local;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "tweet")
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private User user;
    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date date;

    @NotBlank
    @Column(columnDefinition = "TEXT")
    @Size(max = 140, message = "Maximum lenght: 140 characters!")
    private String text;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tweet",cascade = CascadeType.ALL)
    private List<Comment> comments;

    public Tweet(){}

    public Tweet(User user, java.util.Date date, String text, List<Comment> comments) {
        this.user = user;
        this.date = date;
        this.text = text;
        this.comments = comments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public java.util.Date getDate() {

        return date;
    }

    public void setDate(java.util.Date date){
       // SimpleDateFormat fd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      //      this.date = LocalDateTime.parse(date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
//        LocalDateTime created = task.getCreated();
//        String formatedDate = created.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
