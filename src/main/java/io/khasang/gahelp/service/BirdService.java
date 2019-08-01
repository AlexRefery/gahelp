package io.khasang.gahelp.service;

import io.khasang.gahelp.entity.Bird;
import io.khasang.gahelp.entity.Horse;

import java.util.List;

public interface BirdService {
    /**
     * service for adding bird
     * @param bird for adding
     * @return added bird
     */
    Bird add(Bird bird);

    /**
     * service for getting bird by id
     * @param id - bird's id
     * @return specific bird by id
     */
    Bird getById(long id);

    /**
     * service for getting all birds
     * @return all birdss
     */
    List<Bird> getAll();

    /**
     * service for deleting bird by id
     * @param id - bird's id
     * @return deleted bird
     */
    Bird deleteById(long id);

    /**
     * service for updating bird by id
     * @param id - bird's id
     * @param bird - new bird for updating in database
     * @return - updating bird
     */
    Bird updateById(long id, Bird bird);
}