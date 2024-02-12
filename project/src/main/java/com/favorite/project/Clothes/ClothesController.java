package com.favorite.project.Clothes;

import com.favorite.project.Clothes.dto.ClothesAddDto;
import com.favorite.project.Clothes.dto.ClothesResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ClothesController {

    private final ClothesService clothesService;


    @PostMapping("/clothes")
    public ResponseEntity<ClothesResponseDto> addClothes(@RequestBody ClothesAddDto clothesAddDto) {
        //TODO: 옷장이 유효한지 검증, 유요한 옷타입 카테고리인지 검증
        ClothesResponseDto clothesResponseDto = clothesService.addClothes(clothesAddDto);
        return new ResponseEntity<>(clothesResponseDto, HttpStatus.OK);


    }

}
