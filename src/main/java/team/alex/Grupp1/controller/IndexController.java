package team.alex.Grupp1.controller;


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import team.alex.Grupp1.entity.Person;
import team.alex.Grupp1.repositories.PersonRepository;

@RestController
public class IndexController {

	@Autowired
	PersonRepository personRepo;
	
	@PostConstruct
	public void init() {
		Person person1 = new Person("Olle", "Johansson", 23, 'm', 101010, "Malmö", "Sverige");
    	Person person2 = new Person("Frida", "Ek", 32, 'f', 101011, "Malmö", "Sverige");
    	Person person3 = new Person("Alexander", "Raunert", 28, 'm', 101012, "Malmö", "Sverige");
    	Person person4 = new Person("Nedim", "Kanat", 20, 'm', 101013, "Malmö", "Sverige");

    	personRepo.save(person1);
    	personRepo.save(person2);
    	personRepo.save(person3);
    	personRepo.save(person4);
	}
	
    @GetMapping("/")
    public ModelAndView index() {
	
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }

    @GetMapping("/error")
    public ModelAndView error() {
        // Render error(.html)
        ModelAndView mv = new ModelAndView("error");
        return mv;
    }

}