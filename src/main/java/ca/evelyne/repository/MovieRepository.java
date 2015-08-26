package ca.evelyne.repository;

import ca.evelyne.domain.movie.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Flyne on 12/07/2015.
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {


}
