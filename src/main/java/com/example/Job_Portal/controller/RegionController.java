package com.example.Job_Portal.controller;

import com.example.Job_Portal.entity.Region;
import com.example.Job_Portal.repository.RegionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class RegionController {

    private final RegionRepo regionRepo;

    @GetMapping("/region")
    public String addRegion(Model model) {
        Region region = new Region();
        model.addAttribute("region", region);
        return "create_region";
    }

    @GetMapping("/regions")
    public String editRegion(Model model) {
        model.addAttribute("regions", regionRepo.findAll());
        return "regions";
    }

    @GetMapping("/regions/{id}")
    public String getRegion(Model model, @PathVariable Long id) {
        model.addAttribute("region", regionRepo.getRegionById(id));
        return "regions";
    }

    @PostMapping("/region")
    public String saveRegion(@ModelAttribute Region region) {
        regionRepo.save(region);
        return "redirect:/main";
    }

    @GetMapping("/regions/{id}/update")
    public String updateRegion(@PathVariable Long id, Model model) {
        Region region = regionRepo.getRegionById(id);
        model.addAttribute("region", region);
        return "edit_region";
    }

    @PostMapping("/region/{id}")
    public String saveUpdateRegion(@ModelAttribute Region region, @PathVariable Long id) {
        Region existRegion = regionRepo.getRegionById(id);
        existRegion.setId(region.getId());
        existRegion.setName(region.getName());
        regionRepo.save(existRegion);
        return "redirect:/main";
    }

    @GetMapping("/region/{id}")
    public String deleteRegion(@PathVariable Long id) {
        regionRepo.deleteById(id);
        return "redirect:/regions";
    }
}
