package ca.evelyne.controller;


import ca.evelyne.domain.person.Actor;
import ca.evelyne.domain.person.Gender;
import ca.evelyne.domain.person.MovieCharacter;
import ca.evelyne.repository.ActorRepository;
import ca.evelyne.repository.MovieCharacterRepository;
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
@RequestMapping("/actor")
public class ActorController {

    @Autowired
    ActorRepository actorRepository;

    @Autowired
    MovieCharacterRepository movieCharacterRepository;


    //Find all actors
    @RequestMapping("/all")
    public String allActorsSortAlfa(Map<String, Object> model)   {
        model.put("actor", actorRepository.findAll(new Sort(new Sort.Order(Sort.Direction.ASC, "lastName"))));
        return "actorlist";
    }


    //find actor by id and show details
    @RequestMapping(value = "/id/{id}", method = GET)
    public String actorById(Map<String, Object> model, @PathVariable("id") int actorId) {
        model.put("actor", actorRepository.findOne(actorId));
        return "actordetail";
    }


    //GET-method of the create-page
    @RequestMapping(value="/form", method = RequestMethod.GET)
    public String actorForm(Map<String, Object> model, @RequestParam(value = "id",required = false) Integer actorId)    {
        if(actorId!=null)    {
            model.put("actor", actorRepository.findOne(actorId));
        } else {
            model.put("actor", new Actor());
        }
        return "actorform";
    }



    //POST-method of the create-page
    @RequestMapping(value= "/create", method = RequestMethod.POST)
    public String createActor(@Valid Actor actor, BindingResult bindingResult)  {
//        if(bindingResult.hasErrors())   {
//            return "actorform";
//        }
        actorRepository.save(actor);
        return "redirect:/actor/all";
    }


    //delete actor
    @RequestMapping(value="/delete/id/{id}")
    public String deleteActor(@PathVariable("id") int actorId)    {

        Actor actor = actorRepository.getOne(actorId);
        List<MovieCharacter> byActor = movieCharacterRepository.findByActor(actor);
        for (MovieCharacter movieCharacter : byActor) {
            movieCharacter.setActor(null);
            movieCharacterRepository.save(movieCharacter);
        }
        actorRepository.delete(actorId);
        return "redirect:/actor/all";
    }

    //put gender-enum values in a list so we can use it for the dropdown menu
    @ModelAttribute(value = "genders")
    public List<Gender> genders(){

        List<Gender> genders = new ArrayList<>();
        for (Gender g: Gender.values()){
            genders.add(g);
        }
        return genders;
    }



}
