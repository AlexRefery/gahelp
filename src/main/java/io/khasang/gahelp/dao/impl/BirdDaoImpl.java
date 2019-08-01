package io.khasang.gahelp.dao.impl;

import io.khasang.gahelp.dao.BirdDao;
import io.khasang.gahelp.entity.Bird;

public class BirdDaoImpl extends BasicDaoImpl<Bird> implements BirdDao {
    public BirdDaoImpl(Class<Bird> entityClass) {
        super(entityClass);
    }
}
