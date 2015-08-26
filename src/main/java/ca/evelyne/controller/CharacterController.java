package ca.evelyne.controller;

import ca.evelyne.domain.movie.Genre;
import ca.evelyne.domain.movie.Movie;
import ca.evelyne.domain.person.Actor;
import ca.evelyne.domain.person.MovieCharacter;
import ca.evelyne.repository.ActorRepository;
import ca.evelyne.repository.MovieCharacterRepository;
import ca.evelyne.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/character")
public class CharacterController {
    @Autowired
    MovieCharacterRepository movieCharacterRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    ActorRepository actorRepository;

    //Find all characters
    @RequestMapping("/all")
    public String allCharactersSortAlfa(Map<String, Object> model)   {
        model.put("movieCharacter", movieCharacterRepository.findAll(new Sort(new Sort.Order(Sort.Direction.ASC, "name"))));
        return "characterlist";
    }


    //find characters by id and show details
    @RequestMapping(value = "/id/{id}", method = GET)
    public String characterById(Map<String, Object> model, @PathVariable("id") int characterId) {
        model.put("movieCharacter", movieCharacterRepository.findOne(characterId));
        return "characterdetail";
    }


    // this is the link in the moviedetails.jsp == /form?id={id}?movieId={movieId}

    //GET-method of the create-page
    @RequestMapping(value="/form", method = RequestMethod.GET)
    public String characterForm(Map<String, Object> model, @RequestParam(value = "id",required = false) Integer characterId, @RequestParam(value="movieId") int movieId)    {
        if(characterId!=null)    {
            model.put("movieCharacter", movieCharacterRepository.findOne(characterId));
        } else {
            model.put("movieCharacter", new MovieCharacter());
        }
        return "characterform";
    }

    //POST-method of the create-page
    @RequestMapping(value= "/create", method = RequestMethod.POST)
    public String createCharacter(@Valid MovieCharacter movieCharacter, BindingResult bindingResult, @RequestParam("movieId") int movieId)  {
        if(bindingResult.hasErrors())   {
            return "characterform";
        }
        if(movieCharacter.getId() == null) {
            Movie movie = movieRepository.getOne(movieId);
            movie.getCast().add(movieCharacter);

            movieCharacterRepository.save(movieCharacter);
            movieRepository.save(movie);
        } else  {
            Movie movie = movieRepository.getOne(movieId);
            movie.getCast().add(movieCharacter);

            movieRepository.save(movie);
            movieCharacterRepository.save(movieCharacter);
        }
        return "redirect:/movie/id/" + movieId;
    }



    //delete characters
    @RequestMapping(value="/delete/id/{id}/{movieId}")
    public String deleteCharacter(@PathVariable("id") int characterId, @PathVariable("movieId") int movieId)    {
        Movie movie = movieRepository.getOne(movieId);
        //use Iterator to keep a pointer while looping over the database (otherwise there will be concurrency errors
        //because there are records being deleted while looping over the db
        Iterator<MovieCharacter> it = movie.getCast().iterator();
        while(it.hasNext()) {
            MovieCharacter next = it.next();
            if(next.getId() == characterId)   {
                it.remove();
            }
        }

        movieRepository.save(movie);
        movieCharacterRepository.delete(characterId);
        return "redirect:/movie/id/{movieId}";
    }


    //put actors in a list so we can use it for the dropdown menu
    @ModelAttribute(value = "getactorlist")
    public List<Actor> actors(){
        return actorRepository.findAll();
    }



}
