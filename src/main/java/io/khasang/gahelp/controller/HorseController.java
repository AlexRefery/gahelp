package io.khasang.gahelp.controller;

import io.khasang.gahelp.entity.Horse;
import io.khasang.gahelp.service.HorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/horse")
public class HorseController {
    private HorseService horseService;

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Horse addHorse(@RequestBody Horse horse){
        return horseService.add(horse);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Horse getHorseById(@PathVariable("id") long id){
        return horseService.getById(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Horse> getAllHorse(){
        return horseService.getAll();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Horse deleteHorseById(@PathVariable("id") long id){
        return horseService.deleteById(id);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Horse updateHorseById(@RequestBody Horse horse, @PathVariable("id") long id){
        return horseService.updateById(id, horse);
    }

    @Autowired
    public void setHorseService(HorseService horseService) {
        this.horseService = horseService;
    }
}
