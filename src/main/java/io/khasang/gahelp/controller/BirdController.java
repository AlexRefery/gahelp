package io.khasang.gahelp.controller;

import io.khasang.gahelp.entity.Bird;
import io.khasang.gahelp.service.BirdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/bird")
public class BirdController {
    private BirdService birdService;

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Bird addBird(@RequestBody Bird bird){
        return birdService.add(bird);
    }

    @GetMapping(value = "/get/{id}")
    @ResponseBody
    public Bird getBirdById(@PathVariable("id") long id){
        return birdService.getById(id);
    }

    @GetMapping(value = "/all")
    @ResponseBody
    public List<Bird> getAll(){
        return birdService.getAll();
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseBody
    public Bird deleteBirdById(@PathVariable("id") long id){
        return birdService.deleteById(id);
    }

    @PutMapping(value = "/update/{id}")
    @ResponseBody
    public Bird updateBird(@RequestBody Bird bird, @PathVariable("id") long id){
        return birdService.updateById(id, bird);
    }

    @Autowired
    public void setBirdService(BirdService birdService) {
        this.birdService = birdService;
    }
}
