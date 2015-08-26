package ca.evelyne.controller;

import ca.evelyne.domain.person.Gender;
import ca.evelyne.domain.person.User;
import ca.evelyne.repository.UserRepository;
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
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepository;


    //Find all users
    @RequestMapping("/all")
    public String allUsersSortAlfa(Map<String, Object> model)   {
        model.put("user", userRepository.findAll(new Sort(new Sort.Order(Sort.Direction.ASC, "login"))));
        return "userlist";
    }


    //find users by id and show details
    @RequestMapping(value = "/id/{id}", method = GET)
    public String userById(Map<String, Object> model, @PathVariable("id") int userId) {
        model.put("user", userRepository.findOne(userId));
        return "userdetail";
    }


    //GET-method of the create-page
    @RequestMapping(value="/form", method = RequestMethod.GET)
    public String userForm(Map<String, Object> model, @RequestParam(value = "id",required = false) Integer userId)    {
        if(userId!=null)    {
            model.put("user", userRepository.findOne(userId));
        } else {
            model.put("user", new User());
        }
        return "userform";
    }


    //POST-method of the create-page
    @RequestMapping(value= "/create", method = RequestMethod.POST)
    public String createUser(@Valid User user, BindingResult bindingResult)  {
        if(bindingResult.hasErrors())   {
            return "userform";
        }
        user.setPassword(Integer.toString(user.getPassword().hashCode()));
        userRepository.save(user);
        return "redirect:/";
    }


    //delete users
    @RequestMapping(value="/delete/id/{id}")
    public String deleteUser(@PathVariable("id") int userId)    {
        userRepository.delete(userId);
        return "redirect:/";
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
