package io.khasang.gahelp.controller;

import io.khasang.gahelp.model.Cat;
import io.khasang.gahelp.model.CreateTable;
import io.khasang.gahelp.model.Dog;
import io.khasang.gahelp.service.KnightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@ImportResource(value = "classpath:ioc.xml")
public class AppController {
    private Cat cat;
    private Dog dog;
    private KnightService knightService;
    private CreateTable createTable;

//    public AppController(Cat cat, Dog dog) {
//        this.cat = cat;
//        this.dog = dog;
//    }

    //    public AppController(Cat cat) {
//        this.cat = cat;
//    }
//
//    public AppController(Dog dog) {
//        this.dog = dog;
//    }

    @RequestMapping("/password/{password}")
    public String getEncryptPassword(@PathVariable("password") String password, Model model){
        model.addAttribute("password", password);
        model.addAttribute("passwordAfterEncode", new BCryptPasswordEncoder().encode(password));
        return "password";
    }

    @RequestMapping("/admin")
    public String getAdminPage(){
        return "admin";
    }

    @RequestMapping("/user")
    public String getUserPage(){
        return "user";
    }

    @RequestMapping("/cat/{name}")
    public String getCatCount(@PathVariable("name") String name, Model model){
        model.addAttribute("name", name);
        model.addAttribute("count", createTable.getInfo(name));
        return "catcount";
    }

    @RequestMapping("/hair/{name}")
    public String setHair(@PathVariable("name") String name, Model model){
        model.addAttribute("name", name);
        model.addAttribute("count", createTable.setUpdateHair(name));
        return "haircount";
    }

    @RequestMapping("/create")
    public String getTableCreationStatus(Model model){
        model.addAttribute("status", createTable.tableCreationStatus());
        return "create";
    }

    @RequestMapping("/")
    public String getStatus(){
        return "status";
    }

    @RequestMapping("/bird/api")
    public String birdStatus(){
        return "bird";
    }

    @RequestMapping("/hello/{name}")
    public String getHelloPage (@PathVariable("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello";
    }

    @RequestMapping("/{name}")
    public String getCatName(@PathVariable("name") String name1, Model model){
        model.addAttribute("name", cat.getName() + " " + name1);
        return "cat";
    }

    @RequestMapping("/info")
    public String getInfo(Model model){
        model.addAttribute("info", dog.getInfo());
        return "info";
    }

    @RequestMapping("knight/fight/{enemy}")
    public String getKnightFightInfo(@PathVariable("enemy") String enemy, Model model ){
        model.addAttribute("info", knightService.getAchievement(enemy));
        return "knight";
    }

//    @Autowired
////    @Value("Мурзик")
//    public void setCat(Cat cat) {
//        this.cat = cat;
//    }
//
//    @Autowired
//    public void setDog(Dog dog) {
//        this.dog = dog;
//    }
//

    @Autowired
    public void setKnightService(KnightService knightService) {
        this.knightService = knightService;
    }

    @Autowired
    public void setCreateTable(CreateTable createTable) {
        this.createTable = createTable;
    }
}
