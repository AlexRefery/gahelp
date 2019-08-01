package io.khasang.gahelp.model;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Cat implements DisposableBean, InitializingBean, BeanClassLoaderAware, BeanFactoryAware,
                            BeanNameAware, ApplicationContextAware {
    private String name;

//    @Autowired
    public Cat(String name) {
        this.name = name;
    }

    public Cat() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("calling afterPropertiesSet()");
    }

    @PostConstruct
    public void init(){
        System.out.println("Calling @PostConstruct");
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("Calling setBeanClassLoader()");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("Calling setBeanFactory()");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Calling setBeanName()");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Calling setApplicationContext()");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("Calling preDestroy");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Calling destroy() DisposableBean");
    }
}
