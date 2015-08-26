package ca.evelyne.domain.converter;

import ca.evelyne.domain.person.Actor;
import ca.evelyne.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by Evelyne on 15/07/15.
 */


@Component
public class StringToActorConverter implements Converter<String, Actor> {

    @Autowired
    ActorRepository actorRepository;

    @Override
    public Actor convert(String source) {
        int i = Integer.parseInt(source);
        Actor actor = actorRepository.findOne(i);
        return actor;
    }


}
