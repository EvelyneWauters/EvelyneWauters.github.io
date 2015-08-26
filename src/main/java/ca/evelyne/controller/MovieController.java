package ca.evelyne.controller;

import ca.evelyne.domain.movie.Comment;
import ca.evelyne.domain.movie.Genre;
import ca.evelyne.domain.movie.Movie;
import ca.evelyne.repository.CommentRepository;
import ca.evelyne.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


@Controller
@RequestMapping("movie")
public class MovieController {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    CommentRepository commentRepository;


    //Find all movies
    @RequestMapping("/all")
    public String allMoviesSortAlfa(Map<String, Object> model)   {
        model.put("movie", movieRepository.findAll(new Sort(new Sort.Order(Sort.Direction.ASC, "title"))));
        return "movielist";
    }

    //Find all movies
    @RequestMapping("/allsortonrating")
    public String allMoviesSortOnRating(Map<String, Object> model)   {
        model.put("movie", movieRepository.findAll(new Sort(new Sort.Order(Sort.Direction.DESC, "rating"))));
        return "movielist";
    }

    //find movie by id and show details
   @RequestMapping(value = "/id/{id}", method = GET)
    public String movieById(Map<String, Object> model, @PathVariable("id") int movieId) {
        model.put("movie", movieRepository.findOne(movieId));
        return "moviedetail";
    }


    //GET-method of the create-page
    @RequestMapping(value="/form", method = RequestMethod.GET)
    public String form(Map<String, Object> model, @RequestParam(value = "id",required = false) Integer filmId)    {
        if(filmId!=null)    {
            model.put("movie", movieRepository.findOne(filmId));
        } else {
            model.put("movie", new Movie());
        }
        return "movieform";
    }



    //POST-method of the create-page
    @RequestMapping(value= "/create", method = RequestMethod.POST)
    public String create(@Valid Movie movie, BindingResult bindingResult)  {
        if(bindingResult.hasErrors())   {
            return "movieform";
        }
        movieRepository.save(movie);
        return "redirect:/movie/all";
    }


    //delete movie & its comments
    @RequestMapping(value="/delete/id/{id}")
    public String delete(@PathVariable("id") int movieId, Map<String, Object> model)    {
        List<Comment> byMovieId = commentRepository.getByMovieId(movieId);
        commentRepository.delete(byMovieId);
        movieRepository.delete(movieId);
        //model.remove(movieId);
        return "redirect:/movie/all";
    }


//    //delete characters
//    @RequestMapping(value="/delete/id/{id}/{movieId}")
//    public String deleteCharacter(@PathVariable("id") int characterId, @PathVariable("movieId") int movieId)    {
//        Movie movie = movieRepository.getOne(movieId);
//        //use Iterator to keep a pointer while looping over the database (otherwise there will be concurrency errors
//        //because there are records being deleted while looping over the db
//        Iterator<MovieCharacter> it = movie.getCast().iterator();
//        while(it.hasNext()) {
//            MovieCharacter next = it.next();
//            if(next.getId() == characterId)   {
//                it.remove();
//            }
//        }
//
//        movieRepository.save(movie);
//        movieCharacterRepository.delete(characterId);
//        return "redirect:/movie/id/{movieId}";
//    }


    //put genre-enum values in a list so we can use it for the dropdown menu
    @ModelAttribute(value = "genres")
    public List<Genre> genres(){
        List<Genre> genres = new ArrayList<>();
        for (Genre g: Genre.values()){
            genres.add(g);
        }
        return genres;
    }


}
