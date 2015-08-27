package ca.evelyne.repository;

import ca.evelyne.domain.Recipe;
import ca.evelyne.domain.person.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Evelyne on 26/08/15.
 */

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {


}
