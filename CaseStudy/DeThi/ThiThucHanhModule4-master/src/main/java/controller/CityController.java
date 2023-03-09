package controller;

import model.City;
import model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import service.CityService;
import service.CountryService;


@Controller
public class CityController {
    @Autowired
    CountryService countryService;

    @Autowired
    CityService cityService;

    @ModelAttribute("countries")
    Iterable<Country> countries(){return countryService.findAll();}

    @GetMapping("/")
    public ModelAndView getListing(Pageable pageable){
        ModelAndView modelAnView = new ModelAndView("listing");
        Page<City> cities = cityService.findAll(pageable);
        modelAnView.addObject("cities",cities);
        return modelAnView;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView getDetail(@PathVariable("id") Long id){
        ModelAndView modelAndView = new ModelAndView("detail");
        City currentCity = cityService.findById(id);
        modelAndView.addObject("city",currentCity);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteCity(@PathVariable("id") Long id, Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("listing");
        cityService.deleteById(id);
        Page<City> cities = cityService.findAll(pageable);
        modelAndView.addObject("cities",cities);
        modelAndView.addObject("message","Xóa thành công!");
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView getCreateForm(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("city",new City());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createCity(@Validated @ModelAttribute("city") City city, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("create");
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView("create");
        cityService.save(city);
        modelAndView.addObject("city",new City());
        modelAndView.addObject("message","Thêm thành công!");
        return modelAndView;
    }

    @GetMapping("/update/{id}")
    public ModelAndView getUpdateForm(@PathVariable("id") Long id){
        ModelAndView modelAndView = new ModelAndView("update");
        City currentCity = cityService.findById(id);
        modelAndView.addObject("city",currentCity);
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView updateCity(@ModelAttribute("city") City city){
        ModelAndView modelAndView = new ModelAndView("update");
        cityService.save(city);
        modelAndView.addObject("city",city);
        modelAndView.addObject("message","Sửa thành công!");
        return modelAndView;
    }
}
