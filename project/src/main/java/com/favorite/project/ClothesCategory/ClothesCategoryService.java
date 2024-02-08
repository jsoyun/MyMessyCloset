package com.favorite.project.ClothesCategory;

import com.favorite.project.ClothesCategory.Mapper.CategoryMapper;
import com.favorite.project.ClothesCategory.domain.ClothesCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ClothesCategoryService {
    private final CategoryMapper categoryMapper;

    public ClothesCategoryEnumType addCategory(ClothesCategoryEnumType clothesCategoryEnumType) {
        categoryMapper.insertClothesCategory(clothesCategoryEnumType);
        return clothesCategoryEnumType;
    }


}
