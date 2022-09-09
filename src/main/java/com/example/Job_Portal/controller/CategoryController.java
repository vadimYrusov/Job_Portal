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
        return "category";
    }

    @GetMapping("/categories")
    public String editCategory(Model model) {
        model.addAttribute("categories", categoryRepo.findAll());
        return "categories";
    }

//    @GetMapping("/categories/{id}")
//    public String getCategory(Model model, @PathVariable Long id) {
//        model.addAttribute("categories", categoryRepo.findById(id));
//        return "categories";
//    }
//
//    @PostMapping("/category")
//    public String saveCategory(@ModelAttribute Category category) {
//        categoryRepo.save(category);
//        return "redirect:/items";
//    }
//
//    @GetMapping("/categories/{id}")
//    public String updateCategory(@PathVariable Long id, Model model) {
//        Category category = categoryRepo.findById(id).get();
//        model.addAttribute("category", category);
//        return "category_edit";
//    }
//
//    @PostMapping("/category/{id}")
//    public String saveUpdateItem(@ModelAttribute Category category, @PathVariable Long id) {
//        Category existCategory = categoryRepo.findById(id).get();
//        existCategory.setId(category.getId());
//        existCategory.setCategory(category.getCategory());
//        categoryRepo.save(existCategory);
//        return "redirect:/items";
//    }

    @GetMapping("/category/{id}")
    public String deleteCategory(@PathVariable Long id) {
        categoryRepo.deleteById(id);
        return "redirect:/categories";
    }
}
