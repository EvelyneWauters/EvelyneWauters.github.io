package ca.evelyne.repository;

import ca.evelyne.domain.person.Actor;
import ca.evelyne.domain.person.MovieCharacter;
import ca.evelyne.domain.person.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Flyne on 12/07/2015.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByLogin(String login);
}
