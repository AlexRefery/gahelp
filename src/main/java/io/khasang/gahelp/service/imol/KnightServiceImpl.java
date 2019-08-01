package io.khasang.gahelp.service.imol;

import io.khasang.gahelp.service.KnightService;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class KnightServiceImpl implements KnightService {

    @Override
    public String getAchievement(String enemy) {
        try {
            TimeUnit.MILLISECONDS.sleep(120);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (enemy.equalsIgnoreCase("dragon")){
            throw new IllegalArgumentException("Dragon has eaten the knight");
        }
        return "I am slave a " + enemy + "!";
    }
}
