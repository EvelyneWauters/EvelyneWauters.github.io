package ca.evelyne.service;

import ca.evelyne.domain.movie.Comment;
import ca.evelyne.repository.CommentRepository;
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
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@RestController
@RequestMapping("service/comment")
public class CommentService {
    @Autowired
    CommentRepository commentRepository;

    @RequestMapping(value="/all")
    public List<Comment> findAllComments()  {
        return commentRepository.findAll();
    }

    @RequestMapping(value = "/id/{commentId}", method = GET)
    public ResponseEntity<Comment> findById(@PathVariable("commentId") int id) {
        Comment comment = commentRepository.findOne(id);
        if(comment == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(comment, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/delete/{commentId}", method = DELETE)
    public void removeById(@PathVariable("commentId") int id) {
        commentRepository.delete(id);
    }

    @RequestMapping(value = "/create", method = POST, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity create(@RequestBody Comment comment) {
        commentRepository.save(comment);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "http://localhost:8080/comment/" + comment.getId());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }
}
