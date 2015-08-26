package ca.evelyne.service;

import ca.evelyne.domain.person.User;
import ca.evelyne.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by Flyne on 12/07/2015.
 */
@RestController
@RequestMapping("service/user")
public class UserService {
    @Autowired
    UserRepository userRepository;


    @RequestMapping(value="all")
    public List<User> findAllUsers()    {
        return userRepository.findAll();
    }

    @RequestMapping(value="id/{userId}")
    public ResponseEntity<User> findUserById(@PathVariable("userId") int id)    {
        User user = userRepository.findOne(id);
        if(user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "delete/{userId}", method = DELETE)
    public void removeById(@PathVariable("userId") int id) {
        userRepository.delete(id);
    }


    @RequestMapping(value = "create", method = POST, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity create(@RequestBody User user) {
        userRepository.save(user);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "http://localhost:8080/user/" + user.getId());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    }
