package ca.evelyne.controller;

import ca.evelyne.domain.MealType;
import ca.evelyne.domain.Recipe;
import ca.evelyne.repository.RecipeRepository;
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
@RequestMapping("recipe")
public class RecipeController {

    @Autowired
    RecipeRepository recipeRepository;


    //Find all movies
    @RequestMapping("/all")
    public String allRecipesSortAlfa(Map<String, Object> model)   {
        model.put("recipe", recipeRepository.findAll(new Sort(new Sort.Order(Sort.Direction.ASC, "name"))));
        return "recipelist";
    }

//    //Find all movies
//    @RequestMapping("/allsortonrating")
//    public String allMoviesSortOnRating(Map<String, Object> model)   {
//        model.put("movie", recipeRepository.findAll(new Sort(new Sort.Order(Sort.Direction.DESC, "rating"))));
//        return "movielist";
//    }

    //find movie by id and show details
    @RequestMapping(value = "/id/{id}", method = GET)
    public String movieById(Map<String, Object> model, @PathVariable("id") int recipeId) {
        model.put("recipe", recipeRepository.findOne(recipeId));
        return "recipedetail";
    }


    //GET-method of the create-page
    @RequestMapping(value="/form", method = RequestMethod.GET)
    public String form(Map<String, Object> model, @RequestParam(value = "id",required = false) Integer recipeId)    {
        if(recipeId!=null)    {
            model.put("recipe", recipeRepository.findOne(recipeId));
        } else {
            model.put("recipe", new Recipe());
        }
        return "recipeform";
    }



    //POST-method of the create-page
    @RequestMapping(value= "/create", method = RequestMethod.POST)
    public String create(@Valid Recipe recipe, BindingResult bindingResult)  {
        if(bindingResult.hasErrors())   {
            return "recipeform";
        }
        recipeRepository.save(recipe);
        return "redirect:/recipe/all";
    }


    //delete movie & its comments
    @RequestMapping(value="/delete/id/{id}")
    public String delete(@PathVariable("id") int recipeId, Map<String, Object> model)    {
        recipeRepository.delete(recipeId);
        return "redirect:/recipe/all";
    }


    //put genre-enum values in a list so we can use it for the dropdown menu
    @ModelAttribute(value = "mealtypes")
    public List<MealType> genres(){
        List<MealType> mealTypes = new ArrayList<>();
        for (MealType g: MealType.values()){
            mealTypes.add(g);
        }
        return mealTypes;
    }
}
