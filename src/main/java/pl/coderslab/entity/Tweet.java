package pl.coderslab.entity;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.cglib.core.Local;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.sql.Date;

@Entity
@Table(name = "tweet")
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private User user;
    @Column(updatable = false)
    private Date date;
    @NotBlank
    @Column(columnDefinition = "TEXT")
    @Size(max = 140, message = "Maximum lenght: 140 characters!")
    private String text;

    public Tweet(){}

    public Tweet(User user, Date date, String text) {
        this.user = user;
        this.date = date;
        this.text = text;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date){
       // SimpleDateFormat fd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      //      this.date = LocalDateTime.parse(date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
