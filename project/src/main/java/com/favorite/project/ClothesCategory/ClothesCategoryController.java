package com.favorite.project.ClothesCategory;

import com.favorite.project.ClothesCategory.domain.ClothesCategory;
import com.favorite.project.ClothesCategory.dto.CategoryAddDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ClothesCategoryController {

    private final ClothesCategoryService clothesCategoryService;

    @GetMapping("/clothesCategory")
    public String addClothesCateory(@ModelAttribute CategoryAddDto categoryAddDto) {
        clothesCategoryService.addCategory(categoryAddDto);
        return "옷 카테고리 추가 성공";
    }


}
