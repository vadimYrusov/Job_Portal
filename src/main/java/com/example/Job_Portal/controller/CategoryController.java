package com.example.Job_Portal.controller;

import com.example.Job_Portal.entity.Category;
import com.example.Job_Portal.repository.CategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryRepo categoryRepo;

    @GetMapping("/category")
    public String addCategory(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        model.addAttribute("keyword", "");
        return "create_category";
    }

    @GetMapping("/categories")
    public String listCategories(Model model) {
        model.addAttribute("categories", categoryRepo.findAll());
        model.addAttribute("keyword", "");
        return "categories";
    }

    @GetMapping("/categories/{id}")
    public String getCategory(Model model, @PathVariable Long id) {
        model.addAttribute("categories", categoryRepo.findById(id));
        model.addAttribute("keyword", "");
        return "create_category";
    }

    @PostMapping("/category")
    public String saveCategory(@ModelAttribute Category category) {
        categoryRepo.save(category);
        return "redirect:/categories";
    }

    @GetMapping("/category/{id}/update")
    public String updateCategory(@PathVariable Long id, Model model) {
        Category category = categoryRepo.getCategoryById(id);
        model.addAttribute("category", category);
        model.addAttribute("keyword", "");
        return "edit_category";
    }

    @PostMapping("/category/{id}")
    public String saveUpdateItem(@ModelAttribute Category category, @PathVariable Long id) {
        Category existCategory = categoryRepo.getCategoryById(id);
        existCategory.setId(category.getId());
        existCategory.setName(category.getName());
        categoryRepo.save(existCategory);
        return "redirect:/items";
    }

    @GetMapping("/category/{id}")
    public String deleteCategory(@PathVariable Long id) {
        categoryRepo.deleteById(id);
        return "redirect:/categories";
    }
}
