package net.javaguides.Project.controller;

import net.javaguides.Project.model.Animal;
import net.javaguides.Project.model.Medication;
import net.javaguides.Project.model.Skills;
import net.javaguides.Project.service.AnimalService;
import net.javaguides.Project.service.MedicationService;
import net.javaguides.Project.service.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AnimalController {
    @Autowired
    private AnimalService animalService;

    @Autowired
    private MedicationService medicationService;

    @Autowired
    private SkillsService skillsService;

    // For the display of the list of pets available in the store
    @GetMapping("/home")
    public String viewHomePage(Model model) {
        return findPaginated(1, "name", "asc", model);
    }

    @GetMapping("/showNewAnimalForm")
    public String showNewAnimalForm(Model model) {
        // create model attribute to bind form data
        Animal animal = new Animal();
        model.addAttribute("animal", animal);
        return "new_animal";
    }

    @PostMapping("/saveAnimal")
    public String saveAnimal(@ModelAttribute("animal") Animal animal) {
        // save animal to the database
        Medication medication = new Medication(animal.getMedication());
        Skills skills = new Skills(animal.getSkills());

        medicationService.saveMedication(medication);
        skillsService.saveSkills(skills);
        animalService.saveAnimal(animal);
        return "redirect:/home";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") long id, Model model) {

        // get animal from the service
        Animal animal = animalService.getAnimalById(id);

        // set animal as a model attribute to pre-populate the form
        model.addAttribute("animal", animal);
        return "update_animal";
    }
    @GetMapping("/deleteAnimal/{id}")
    public String deleteAnimal(@PathVariable (value = "id") long id){
        //Here we call the delete from the service
        this.animalService.deleteAnimalById(id);
        return "redirect:/home";
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;

        Page < Animal > page = animalService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List < Animal > listAnimals = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listAnimals", listAnimals);
        return "index";
    }
}
