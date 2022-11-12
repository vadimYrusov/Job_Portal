package com.example.Job_Portal.controller;

import com.example.Job_Portal.entity.Form;
import com.example.Job_Portal.entity.Vacancy;
import com.example.Job_Portal.repository.FormRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class FormController {

    private final FormRepo formRepo;

    @GetMapping("/forms")
    public String forms(Model model, String keyword) {

        List<Form> forms;

        if (keyword == null || keyword.trim().equals("")) {
            forms = formRepo.findAll();
        } else {
            forms = formRepo.getByNameContainsIgnoreCase(keyword);
        }

        model.addAttribute("forms", forms);
        model.addAttribute("keyword", "");
        return "forms";
    }

    @GetMapping("/form")
    public String createForm(Model model) {
        Form form = new Form();
        model.addAttribute("form", form);
        model.addAttribute("keyword", "");
        return "create_form";
    }

    @GetMapping("/forms/{id}")
    public String getForm(@PathVariable Long id, Model model) {
        Form form = formRepo.getFormById(id);
        model.addAttribute("form", form);
        model.addAttribute("keyword", "");
        return "form";
    }

    @PostMapping("/forms")
    public String saveForm(@ModelAttribute Form form) {
        formRepo.save(form);
        return "redirect:/forms";
    }

    @GetMapping("/form/{id}")
    public String deleteForm(@PathVariable Long id) {
        formRepo.deleteById(id);
        return "redirect:/forms";
    }

    @GetMapping("/forms/{id}/update")
    public String updateForm(@PathVariable Long id, Model model) {
        Form form = formRepo.getFormById(id);
        model.addAttribute("form", form);
        model.addAttribute("keyword", "");
        return "update_form";
    }

    @PostMapping("/forms/{id}")
    public String saveUpdate(@PathVariable Long id, @ModelAttribute("form") Form form) {
        Form existingForm = formRepo.getFormById(id);
        existingForm.setName(form.getName());
        existingForm.setSurname(form.getSurname());
        existingForm.setPosition(form.getPosition());
        existingForm.setSummary(form.getSummary());
        existingForm.setExperience(form.getExperience());
        existingForm.setPhone(form.getPhone());
        existingForm.setEmail(form.getEmail());
        formRepo.save(existingForm);
        return "redirect:/forms";
    }
 }
