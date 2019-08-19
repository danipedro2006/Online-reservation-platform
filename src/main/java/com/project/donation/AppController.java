package com.project.donation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {
    @Autowired
    private PersonaeService service;
    @RequestMapping(value={"","/","/index"})
    public String viewHomePage(){
       return "index";
    }
    @RequestMapping("/add_personae")
    public String verificareVig(Model model){
        List<Personae> listPeople = service.listAll();
        model.addAttribute("listPeople", listPeople);
        return "add_personae";
    }
    @RequestMapping("/new")
    public String addNewPersone(Model model){
        Personae personae = new Personae();
        model.addAttribute("personae", personae);
        return "new_personae";
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveClient(@ModelAttribute("personae") Personae personae){
        service.save(personae);
        return "redirect:/add_personae";
    }
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditPage(@PathVariable(name = "id") long id){
        ModelAndView mav = new ModelAndView("edit_personae");
        Personae personae = service.getById(id);
        mav.addObject("personae", personae);
        return mav;
    }
    @RequestMapping("/delete/{id}")
    public String deleteClient(@PathVariable(name = "id") long id){
        service.delete(id);
        return "redirect:/add_personae";
    }
}
