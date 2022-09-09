package com.example.Job_Portal.controller;

import com.example.Job_Portal.entity.Vacancy;
import com.example.Job_Portal.repository.VacancyRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class VacancyController {

    private final VacancyRepo vacancyRepo;

    @GetMapping("/jobs")
    public String allJobs(Model model) {
        List<Vacancy> vacancies = vacancyRepo.findAll();
        model.addAttribute("jobs", vacancies);
        return "main";
    }

    @GetMapping("/job")
    public String createJob(Model model) {
        Vacancy vacancy = new Vacancy();
        model.addAttribute("job", vacancy);
        return "create_job";
    }

    @GetMapping ("/jobs/{id}")
    public String getJob(@PathVariable Long id, Model model) {
        Vacancy vacancy = vacancyRepo.findById(id).get();
        model.addAttribute("job", vacancy);
        return "job";
    }

    @PostMapping("/jobs")
    public String saveJob(@ModelAttribute Vacancy vacancy) {
        vacancy.setTime(LocalDateTime.now());
        vacancyRepo.save(vacancy);
        return "redirect:/main";
    }

    @GetMapping ("/job/{id}")
    public String deleteJob(@PathVariable Long id) {
        vacancyRepo.deleteById(id);
        return "redirect:/main";
    }

    @GetMapping("/jobs/{id}/update")
    public String updateJob(@PathVariable Long id, Model model) {
        Vacancy vacancy = vacancyRepo.findById(id).get();
        model.addAttribute("job", vacancy);
        return "update_job";
    }

    @PostMapping("/jobs/{id}")
    public String saveUpdate(@PathVariable Long id, @ModelAttribute("job") Vacancy vacancy) {
        Vacancy existVacancy = vacancyRepo.findById(id).get();
        existVacancy.setName(vacancy.getName());
        existVacancy.setCompany(vacancy.getCompany());
        existVacancy.setRegion(vacancy.getRegion());
        existVacancy.setSalary(vacancy.getSalary());
        existVacancy.setJobDetails(vacancy.getJobDetails());
        existVacancy.setBenefits(vacancy.getBenefits());
        existVacancy.setTime(vacancy.getTime());
        vacancyRepo.save(existVacancy);
        return "redirect:/main";
    }
}
