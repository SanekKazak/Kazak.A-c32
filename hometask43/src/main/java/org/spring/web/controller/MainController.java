package org.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.spring.entity.FilmEntity;
import org.spring.entity.FilmRegisterDto;
import org.spring.mapper.FilmMapper;
import org.spring.persistence.FilmRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final FilmRepository repository;
    private final FilmMapper mapper;
    @GetMapping
    public String index(Model model) {
        List<FilmEntity> all = repository.getAll();
        model.addAttribute("films", all);
        model.addAttribute("film", new FilmRegisterDto());
        return "index";
    }
    @PostMapping
    public String index(
            @Valid @ModelAttribute(name = "filmRegisterDto") FilmRegisterDto dto,
            BindingResult result,
            Model model
    ) {
        if(result.hasErrors()){
            model.addAttribute("filmRegisterDto", dto);
            return "index";
        }
        FilmEntity entity = mapper.toEntity(dto);
        repository.save(entity);
        return "redirect:/";
    }
}
