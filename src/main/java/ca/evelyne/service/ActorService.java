package ca.evelyne.service;

import ca.evelyne.domain.person.Actor;
import ca.evelyne.repository.ActorRepository;
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
import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by Flyne on 12/07/2015.
 */
@RestController
@RequestMapping("service/actor")
public class ActorService {
    @Autowired
    ActorRepository actorRepository;

    @RequestMapping(value="/all")
    public List<Actor> findAllActors()  {
        return actorRepository.findAll();
    }

    @RequestMapping(value = "/id/{actorId}", method = GET)
    public ResponseEntity<Actor> findById(@PathVariable("actorId") int id) {
        Actor actor = actorRepository.findOne(id);
        if(actor == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(actor, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/delete/{actorId}", method = DELETE)
    public void removeById(@PathVariable("actorId") int id) {
        actorRepository.delete(id);
    }

    @RequestMapping(value = "/create", method = POST, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity create(@RequestBody Actor actor) {
        actorRepository.save(actor);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "http://localhost:8080/actor/" + actor.getId());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value="/update", method = PUT, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity update(@RequestBody Actor actor)  {
        actorRepository.save(actor);
        HttpHeaders header = new HttpHeaders();
        header.add("Location", "http://localhost:8080/actor/" + actor.getId());
        return new ResponseEntity(header, HttpStatus.CREATED);
    }

    }
