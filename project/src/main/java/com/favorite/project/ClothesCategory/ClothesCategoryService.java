package com.favorite.project.ClothesCategory;

import com.favorite.project.ClothesCategory.Mapper.CategoryMapper;
import com.favorite.project.ClothesCategory.domain.ClothesCategory;
import com.favorite.project.ClothesCategory.dto.CategoryAddDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ClothesCategoryService {
    private final CategoryMapper categoryMapper;

    public boolean addCategory(CategoryAddDto categoryAddDto) {

        ClothesCategory clothesCategory = categoryAddDto.toClothesCategory(categoryAddDto);
        categoryMapper.insertClothesCategory(clothesCategory.getClothesCategoryEnumType());
        return true;
    }


}
