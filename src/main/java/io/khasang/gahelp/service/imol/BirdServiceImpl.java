package io.khasang.gahelp.service.imol;

import io.khasang.gahelp.dao.BirdDao;
import io.khasang.gahelp.entity.Bird;
import io.khasang.gahelp.service.BirdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("birdService")
public class BirdServiceImpl implements BirdService {
    private BirdDao birdDao;

    @Override
    public Bird add(Bird bird) {
        return birdDao.add(bird);
    }

    @Override
    public Bird getById(long id) {
        return birdDao.getById(id);
    }

    @Override
    public List<Bird> getAll() {
        return birdDao.getAll();
    }

    @Override
    public Bird deleteById(long id) {
        return birdDao.delete(getById(id));
    }

    @Override
    public Bird updateById(long id, Bird bird) {
        if(getById(id) != null){
            bird.setId(id);
        }
        return birdDao.update(bird);
    }

    @Autowired
    public void setBirdDao(BirdDao birdDao) {
        this.birdDao = birdDao;
    }
}
