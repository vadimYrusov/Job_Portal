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

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class VacancyController {

    private final VacancyRepo vacancyRepo;

    @GetMapping("/")
    public String allJobs(Model model) {
        List<Vacancy> vacancies = vacancyRepo.findAll();
        model.addAttribute("jobs", vacancies);
        return "main";
    }

    @GetMapping("/job")
    public String createJob(Model model) {
        Vacancy vacancy = new Vacancy();
        model.addAttribute("jobs", vacancy);
        return "create_job";
    }

    @PostMapping("/job")
    public String saveJob(@ModelAttribute Vacancy vacancy) {
        vacancyRepo.save(vacancy);
        return "main";
    }

    @GetMapping("/job/{id}")
    public String deleteJob(@PathVariable Long id) {
        vacancyRepo.deleteById(id);
        return "main";
    }

    @GetMapping("/{id}")
    public String updateJob(@PathVariable Long id, Model model) {
        Optional<Vacancy> vacancy = vacancyRepo.findById(id);
        model.addAttribute("job", vacancy);
        return "update_job";
    }

    @PostMapping("/{id}")
    public String saveUpdate(@PathVariable Long id,
                             @ModelAttribute("job") Vacancy vacancy) {
        Vacancy existVacancy = vacancyRepo.findById(id).get();
        existVacancy.setName(vacancy.getName());
        existVacancy.setCompany(vacancy.getCompany());
        existVacancy.setRegion(vacancy.getRegion());
        existVacancy.setSalary(vacancy.getSalary());
        existVacancy.setJobDetails(vacancy.getJobDetails());
        existVacancy.setBenefits(vacancy.getBenefits());
        existVacancy.setJobType(vacancy.getJobType());
        existVacancy.setExperience(vacancy.getExperience());
        existVacancy.setTime(vacancy.getTime());
        existVacancy.setContacts(vacancy.getContacts());
        return "main";
    }
}
