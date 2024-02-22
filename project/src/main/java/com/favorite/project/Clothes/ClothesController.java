package com.favorite.project.Clothes;

import com.favorite.project.Clothes.dto.ClothesAddDto;
import com.favorite.project.Clothes.dto.ClothesResponseDto;
import com.favorite.project.User.domain.User;
import com.favorite.project.UserCloset.UserClosetValidator;
import com.favorite.project.Validator.SessionConst;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
public class ClothesController {

    private final ClothesService clothesService;
    private final UserClosetValidator userClosetValidator;


    @PostMapping("/clothes")
    public ResponseEntity<ClothesResponseDto> addClothes(@RequestBody ClothesAddDto clothesAddDto, HttpServletRequest request) {
        // TODO: 유효한 옷타입 카테고리인지 검증

        HttpSession session = request.getSession(false);
        if (session != null) {
            User user = (User) session.getAttribute(SessionConst.USER_SESSION_ID);
            userClosetValidator.checkUserBySession(user.getId());
            ClothesResponseDto clothesResponseDto = clothesService.addClothes(clothesAddDto);
            return new ResponseEntity<>(clothesResponseDto, HttpStatus.OK);

        } else {
            throw new NullPointerException("세션 정보가 없습니다.");
        }
    }


}
