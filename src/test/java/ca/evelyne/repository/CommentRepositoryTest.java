package ca.evelyne.repository;

import ca.evelyne.Application;
import ca.evelyne.domain.movie.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Flyne on 23/07/2015.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class CommentRepositoryTest {
    
    @Autowired
    CommentRepository commentRepository; 
    
    @Test
    public void testGetCommentBymMovieId() throws Exception    {
        int movieId = 2;
        List<Comment> allCommentsByMovieId = commentRepository.getByMovieId(movieId);
        assertEquals(1, allCommentsByMovieId.size());
    }
}
