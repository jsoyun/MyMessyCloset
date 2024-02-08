package com.favorite.project.ClothesCategory;

import com.favorite.project.ClothesCategory.domain.ClothesCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ClothesCategoryController {

    private final ClothesCategoryService clothesCategoryService;

    @GetMapping("/clothesCategory")
    public String addClothesCateory(@RequestParam ClothesCategoryEnumType clothesCategoryEnumType) {
        clothesCategoryService.addCategory(clothesCategoryEnumType);
        return "옷 카테고리 추가 성공";
    }


}
