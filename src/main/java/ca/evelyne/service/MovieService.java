package ca.evelyne.service;
import ca.evelyne.domain.movie.Movie;
import ca.evelyne.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.web.bind.annotation.RequestMethod.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


import java.util.List;

@RestController
@RequestMapping("service/movie")
public class MovieService {
    @Autowired
    MovieRepository movieRepository;


    @RequestMapping("/all")
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @RequestMapping(value = "/id/{movieId}", method = GET)
    public ResponseEntity<Movie> findById(@PathVariable("movieId") int id) {
        Movie movie = movieRepository.findOne(id);
        if(movie == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(movie, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/delete/{movieId}", method = DELETE)
    public void removeById(@PathVariable("movieId") int id) {
        movieRepository.delete(id);
    }

    @RequestMapping(value = "/create", method = POST, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity create(@RequestBody Movie movie) {
        movieRepository.save(movie);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "http://localhost:8080/movie/" + movie.getId());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }
}
