package pl.coderslab.entity;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    @NotBlank
    @Column(columnDefinition = "TEXT")
    private String text;

    @ManyToOne
    private User sender;

    @ManyToOne
    private User receiver;
    @Column(nullable = false)
    private boolean readed = false;
    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date date;
    public Message(){}

    public Message(String title, String text, User sender, User receiver, boolean readed, Date date){
        this.title = title;
        this.text = text;
        this.sender = sender;
        this.receiver = receiver;
        this.readed = readed;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public boolean isReaded() {
        return readed;
    }

    public void setReaded(boolean readed) {
        this.readed = readed;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
