package com.ecommerce.servbyte.service;

import com.ecommerce.servbyte.data.models.Category;

import java.util.List;

public interface CategoryService {
    Category addCategoryToUser(Category category, long idUser);

    Category editCategory(Category category, long id);

    Category findCategoryById(long id);

    void deleteCategory(long id);

    List<Category> findAllCategories();

    List<Category> findCategoriesForUser(long id);
}
