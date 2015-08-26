package ca.evelyne.domain.person;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.sql.Date;
import java.util.List;

@Entity
public class User extends Person {

    private String login;
    private String password;
    private String email;

//TODO: EVENTUEEL nog bidirectioneel maken (zodat per user alle coments gevonden kunnen worden
//    @ManyToOne(mappedBy = "comment")
//    private List<Comment> commentList;

    /**
     * Constructors
     */
    public User() {
    }


    /**
     * Getters & Setters
     */
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
