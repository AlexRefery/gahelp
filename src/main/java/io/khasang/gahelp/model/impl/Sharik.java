package io.khasang.gahelp.model.impl;

import io.khasang.gahelp.model.Dog;
import org.springframework.stereotype.Service;

@Service
public class Sharik implements Dog {

    public Sharik() {
    }

    @Override
    public String getInfo() {
        return "info";
    }
}
