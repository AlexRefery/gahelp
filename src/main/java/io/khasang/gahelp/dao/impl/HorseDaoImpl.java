package io.khasang.gahelp.dao.impl;

import io.khasang.gahelp.dao.HorseDao;
import io.khasang.gahelp.entity.Horse;

import java.util.List;

public class HorseDaoImpl extends BasicDaoImpl<Horse> implements HorseDao {

    public HorseDaoImpl(Class<Horse> entityClass) {
        super(entityClass);
    }
}
