package io.khasang.gahelp.config;

import io.khasang.gahelp.dao.BirdDao;
import io.khasang.gahelp.dao.HorseDao;
import io.khasang.gahelp.dao.impl.BirdDaoImpl;
import io.khasang.gahelp.dao.impl.HorseDaoImpl;
import io.khasang.gahelp.entity.Bird;
import io.khasang.gahelp.entity.Horse;
import io.khasang.gahelp.model.Dog;
import io.khasang.gahelp.model.impl.Sharik;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {
//    @Bean
//    public Cat cat(){
//        return new Cat("Grom");
//    }

    @Bean
    public Dog dog(){
        return new Sharik();
    }

    @Bean
    public HorseDao horseDao(){
        return new HorseDaoImpl(Horse.class);
    }

    @Bean
    public BirdDao birdDao(){
        return new BirdDaoImpl(Bird.class);
    }

}
