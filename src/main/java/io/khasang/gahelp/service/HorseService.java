package io.khasang.gahelp.service;

import io.khasang.gahelp.entity.Horse;

import java.util.List;

public interface HorseService {
    /**
     * service for adding horse
     * @param horse for adding
     * @return added horse
     */
    Horse add(Horse horse);

    /**
     * service for getting horse by id
     * @param id - horse's id
     * @return specific horse by id
     */
    Horse getById(long id);

    /**
     * service for getting all horses
     * @return all horses
     */
    List<Horse> getAll();

    /**
     * service for deleting horse by id
     * @param id - horse's id
     * @return deleted horse
     */
    Horse deleteById(long id);

    /**
     * service for updating horse by id
     * @param id - horse's id
     * @param horse - new horse for updating in database
     * @return - updating horse
     */
    Horse updateById(long id, Horse horse);
}
