package com.favorite.project.Clothes;

import com.favorite.project.Clothes.Mapper.ClothesMapper;
import com.favorite.project.Clothes.domain.Clothes;
import com.favorite.project.Clothes.dto.*;
import com.favorite.project.UserCloset.UserClosetValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClothesService {
    private final ClothesMapper clothesMapper;
    private final UserClosetValidator closetValidator;

    public ClothesInsertionResponseDto addClothes(ClothesAddDto clothesAddDto) {
        Clothes clothes = clothesAddDto.toClothes(clothesAddDto);
        boolean checkValidClosetResult = checkValidCloset(clothes);

        if (checkValidClosetResult) {
            clothesMapper.insertClothes(clothes);
            return clothes.toClothesResponseDto(clothes);

        }
        throw new IllegalArgumentException("유효한 옷장이 아닙니다");


    }


    public boolean checkValidCloset(Clothes clothes) {

        return closetValidator.checkUserCloset(clothes.getUserClosetId());
    }

    public List<UserClosetResponseDto> getAllClothes(int userClosetId) {
        List<ClothesListDto> clothesListDtos = clothesMapper.selectAllClothes(userClosetId);
        List<UserClosetResponseDto> userClosetResponseDtoList = new ArrayList<>();
        for (ClothesListDto clothesListDto : clothesListDtos) {
            UserClosetResponseDto userClosetResponseDTO =
                    UserClosetResponseDto
                            .builder()
                            .build()
                            .toUserClosetIdRequestDto(clothesListDto);
            userClosetResponseDtoList.add(userClosetResponseDTO);
        }

        return userClosetResponseDtoList;

    }


    public List<SeansonResponseDto> getClothesBySeason(SeasonType seasonType) {
        List<ClothesListDto> clothesListDtos = clothesMapper.selectClothesBySeason(seasonType);
        List<SeansonResponseDto> seansonResponseDtoList = new ArrayList<>();
        for (ClothesListDto clothesListDto : clothesListDtos) {
            SeansonResponseDto seansonResponseDto = SeansonResponseDto.builder()
                    .build()
                    .toSeansonResponseDto(clothesListDto);
            seansonResponseDtoList.add(seansonResponseDto);

        }
        return seansonResponseDtoList;

    }


}
