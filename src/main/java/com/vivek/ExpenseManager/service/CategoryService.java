package com.vivek.ExpenseManager.service;


import com.vivek.ExpenseManager.dto.CategoryDTO;
import com.vivek.ExpenseManager.entity.Category;
import com.vivek.ExpenseManager.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(category -> new CategoryDTO(category.getId(), category.getName(), category.getUser().getId()))
                .collect(Collectors.toList());
    }

    public CategoryDTO addCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.getName());
        // Set the user using service methods
        categoryRepository.save(category);
        return categoryDTO;
    }
}
