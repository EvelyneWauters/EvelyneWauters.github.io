package ca.evelyne.repository;

import ca.evelyne.Application;
import ca.evelyne.domain.movie.Movie;
import ca.evelyne.domain.person.Actor;
import ca.evelyne.domain.person.MovieCharacter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class MovieServiceTest {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    MovieCharacterRepository movieCharacterRepository;


    @Autowired
    ActorRepository actorRepository;


    @Test
    public void findMovieById() throws Exception    {
        int id = 2;
        Movie one = movieRepository.findOne(id);
        String title = one.getTitle();
        assertEquals("The Great Gatsby", title );
    }

    @Test
    public void charactersCanBeRetrievedByActor()throws Exception   {
        Actor actor = actorRepository.getOne(10);
        List<MovieCharacter> byActor = movieCharacterRepository.findByActor(actor);
        assertEquals(3,byActor.size());
    }




}
