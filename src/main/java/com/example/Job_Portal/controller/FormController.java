package com.example.Job_Portal.controller;

import com.example.Job_Portal.entity.Form;
import com.example.Job_Portal.repository.FormRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class FormController {

    private final FormRepo formRepo;

    @GetMapping("/forms")
    public String forms(Model model) {
        List<Form> forms = formRepo.findAll();
        model.addAttribute("forms", forms);
        return "forms";
    }

    @GetMapping("/form")
    public String createForm(Model model) {
        Form form = new Form();
        model.addAttribute("form", form);
        return "create_form";
    }

    @GetMapping("/forms/{id}")
    public String getForm(@PathVariable Long id, Model model) {
        Form form = formRepo.findById(id).get();
        model.addAttribute("form", form);
        return "form";
    }

    @PostMapping("/forms")
    public String saveForm(@ModelAttribute Form form) {
        formRepo.save(form);
        return "froms";
    }

    @DeleteMapping("/forms/{id}")
    public String deleteForm(@PathVariable Long id) {
        formRepo.deleteById(id);
        return "forms";
    }

    @PutMapping("/forms/{id}")
    public String updateForm(@PathVariable Long id, Model model) {
        Form form = formRepo.findById(id).get();
        model.addAttribute("form", form);
        return "update_form";
    }

    @PostMapping("/forms/{id}")
    public String saveUpdate(@PathVariable Long id, @ModelAttribute("form") Form form) {
        Form existingForm = formRepo.findById(id).get();
        existingForm.setName(form.getName());
        existingForm.setSurname(form.getSurname());
        existingForm.setPosition(form.getPosition());
        existingForm.setSummary(form.getSummary());
        existingForm.setExperience(form.getExperience());
        existingForm.setSkills(form.getSkills());
        existingForm.setPhone(form.getPhone());
        existingForm.setEmail(form.getEmail());
        formRepo.save(existingForm);
        return "forms";
    }
 }
