package org.spring.jpa.example;

import org.spring.jpa.entity.FilmEntity;
import org.spring.jpa.persistence.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExampleController {
    @Autowired
    private FilmRepository filmRepository;
    @GetMapping
    public String show(){
        var e = new FilmEntity();
        filmRepository.save(e);
        var all = filmRepository.getAll();
        var c = filmRepository.getByName("namr");
        System.out.println(all + " " + c);
        return "";
    }
}
