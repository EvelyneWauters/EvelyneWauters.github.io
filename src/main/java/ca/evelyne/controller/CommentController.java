package ca.evelyne.controller;

import ca.evelyne.domain.movie.Comment;
import ca.evelyne.domain.person.User;
import ca.evelyne.repository.ActorRepository;
import ca.evelyne.repository.CommentRepository;
import ca.evelyne.repository.MovieRepository;
import ca.evelyne.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentRepository commentRepository;

    @Autowired
    ActorRepository actorRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    UserRepository userRepository;


    //Find all comments per movie
    @RequestMapping("/all")
    public String allCommentsPerMovieSortOnDate(Map<String, Object> model, @RequestParam("id") int movieId)   {
        List<Comment> allComments = commentRepository.findAll(new Sort(new Sort.Order(Sort.Direction.ASC, "dateAdded")));
        List<Comment> commentsPerMovie = new ArrayList<>();

        for (Comment comment : allComments) {
            if(comment.getMovie().getId() == movieId)    {
                commentsPerMovie.add(comment);
            }
        }
        model.put("comment", commentsPerMovie);
        return "commentlist";
    }


    //GET-method of the create-page
    @RequestMapping(value="/form", method = RequestMethod.GET)
    public String commentForm(Map<String, Object> model, @RequestParam(value = "movieid") Integer movieId)    {

        model.put("comment", new Comment());
        return "commentform";
    }

    //POST-method of the create-page
    @RequestMapping(value= "/create", method = RequestMethod.POST)
    public String createCharacter(@Valid Comment comment, BindingResult bindingResult, @RequestParam(value = "movieid") Integer movieId)  {
        if(bindingResult.hasErrors())   {
            return "commentform";
        }
        User user = userRepository.findUserByLogin(comment.getUser().getLogin());
        comment.setMovie(movieRepository.findOne(movieId));
        comment.setDateAdded(new Date());

        if(user != null)    {
            if(user.getPassword().equals(Integer.toString(comment.getUser().getPassword().hashCode())))   {
                comment.setUser(user);
                commentRepository.save(comment);
                return "redirect:/comment/all?id=" + comment.getMovie().getId();
            }
        }
        return "redirect:/comment/all?id=" + comment.getMovie().getId();
    }

}
