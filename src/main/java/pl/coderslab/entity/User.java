package pl.coderslab.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    @Size(min = 4, max = 30, message = "Username must be at least 4 and max 30 characters long!")
    private String username;
    @NotBlank
    @Size(min = 4, message = "Password must be at least 4 characters long!")
    private String password;
    private boolean enabled;
    @Email(message = "email format not correct!")
    @Column(unique = true)
    private String email;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user",cascade = CascadeType.ALL)
    private List<Tweet> tweets = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Comment> comments;

    public User(){}

    public User(String username, String password, boolean enabled, String email, List<Tweet> tweets) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.email = email;
        this.tweets = tweets;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(List<Tweet> tweets) {
        this.tweets = tweets;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = BCrypt.hashpw(password,BCrypt.gensalt());
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

//Utwórz	encję	User	encja	ma	posiadać	pola:
//id
//username
//password
//enabled
//email
//Ustaw	wszystkie	pola	jako	wymagane
//Ustaw	walidację	poprawności	adresu	email.
//Pamiętaj	o	haszowaniu	hasła.