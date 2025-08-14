package org.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.spring.dto.FilterDto;
import org.spring.entity.FilmEntity;

import org.spring.persistence.FilmRepository;
import org.spring.service.FilmService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final FilmRepository repository;
    private final FilmService service;
    @GetMapping
    public String index(
            Model model
    ) {
        List<String> all = (List<String>) model.getAttribute("all");
        if(all!=null && !all.isEmpty()) {
            model.addAttribute("films", all);
        } else{
            model.addAttribute("films", repository.findAll());
        }
        model.addAttribute("filter", new FilterDto());
        return "index";
    }
    @PostMapping
    public String index(
            @ModelAttribute(name = "fiter") FilterDto dto,
            RedirectAttributes attributes
    ) {
        List<FilmEntity> allByFilter = service.findAllByFilter(dto);
        attributes.addFlashAttribute("all", allByFilter);
        return "redirect:/";
    }
}
