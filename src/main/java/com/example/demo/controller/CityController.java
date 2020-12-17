package com.example.demo.controller;

import com.example.demo.model.City;
import com.example.demo.model.Nation;
import com.example.demo.service.city.CityService;
import com.example.demo.service.nation.NationService;
import com.example.demo.service.nation.NationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cities")
public class CityController {
    @Autowired
    private CityService cityService;
    @Autowired
    private NationService nationService;
    @ModelAttribute("nation")
    public Iterable<Nation> listNation() {
        return nationService.findAll();
    }

    @GetMapping()
    private ModelAndView listCity(){
        Iterable<City> cities = cityService.findAll();
        ModelAndView modelAndView= new ModelAndView("list");
        modelAndView.addObject("cities", cities);
        return modelAndView;
    }
    @GetMapping("/create")
    private ModelAndView createCity(){
        City city = new City();
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("city", city);
        return modelAndView;
    }
    @PostMapping("/create")
    private ModelAndView showCreateCity(@Validated City city, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            ModelAndView modelAndView = new ModelAndView("/create");
            return modelAndView;
        }
        cityService.save(city);
        ModelAndView modelAndView = new ModelAndView("redirect:/cities");
        modelAndView.addObject("city", new City());
        return  modelAndView;
    }
    @GetMapping("/edit/{id}")
    private ModelAndView editCity(@PathVariable Long id){
        City city = cityService.findById(id);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("city", city);
        return modelAndView;
    }
    @PostMapping("/edit")
    private ModelAndView showEditCity(@Validated City city , BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            ModelAndView modelAndView = new ModelAndView("/edit");
            return modelAndView;
        }
        cityService.save(city);
        ModelAndView modelAndView = new ModelAndView("redirect:/cities");
        modelAndView.addObject("city", city);
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    private ModelAndView deleteCity(@PathVariable Long id) {
        City city = cityService.findById(id);
        cityService.remove(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/cities");
        modelAndView.addObject("city", city);
        return modelAndView;
    }

}
