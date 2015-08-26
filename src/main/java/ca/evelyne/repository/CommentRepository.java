package ca.evelyne.repository;

import ca.evelyne.domain.movie.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Evelyne on 13/07/15.
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    public List<Comment> getByMovieId(int movieId);
}
