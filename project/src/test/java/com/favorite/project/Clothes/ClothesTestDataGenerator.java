package com.favorite.project.Clothes;

import com.favorite.project.Clothes.Mapper.ClothesMapper;
import com.favorite.project.Clothes.domain.Clothes;
import com.favorite.project.Clothes.dto.ClothesAddDto;
import com.favorite.project.ClothesCategory.ClothesCategoryEnumType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;

@SpringBootTest
public class ClothesTestDataGenerator {


    @Autowired
    private ClothesMapper clothesMapper;

    private static Random random = new Random();

    private static ClothesCategoryEnumType[] CATEGORY_ENUM_TYPES
            = {ClothesCategoryEnumType.TOPS, ClothesCategoryEnumType.PANTS, ClothesCategoryEnumType.OUTERWEAR, ClothesCategoryEnumType.ACTIVE};

    private static SeasonType[] SEASONTYPE
            = {SeasonType.SPRING, SeasonType.SUMMER, SeasonType.FALL, SeasonType.WINTER};
    private static String[] ADJECTIVES = {"빛나는", "분홍", "쓸만한", "깔끔한", "허름한", "넉넉한", "구멍난", "낡은", "버릴", "물려받은", "냄새나는", "싫어하는", "화려한", "애정하는"};
    private static String[] CLOTHING_TYPES = {"코트", "옷", "바지", "치마", "원피스", "양말", "운동바지", "학교반티"};
    private static int[] USERCLOSET = {54, 55, 59, 238, 242, 255};

    static LocalDate startDate = LocalDate.of(2010, 1, 1);
    static LocalDate endDate = LocalDate.now();


    static ClothesCategoryEnumType clothesCategoryEnumType;
    static SeasonType seasonType;
    int price = random.nextInt(10000);
    static String imgUrl;
    static int closetId;
    static LocalDate purchasedDate;


    public static void getRandomCategory() {
        clothesCategoryEnumType = CATEGORY_ENUM_TYPES[random.nextInt(CATEGORY_ENUM_TYPES.length)];
        seasonType = SEASONTYPE[random.nextInt(SEASONTYPE.length)];
        imgUrl = ADJECTIVES[random.nextInt(ADJECTIVES.length)] + " " + CLOTHING_TYPES[random.nextInt(CLOTHING_TYPES.length)] + ".jpg";
        seasonType = SEASONTYPE[random.nextInt(SEASONTYPE.length)];
        purchasedDate = LocalDate.ofEpochDay(random.nextInt((int) startDate.until(endDate, ChronoUnit.DAYS) + 1));
        closetId = USERCLOSET[random.nextInt(USERCLOSET.length)];
    }


    //    @RepeatedTest(40000)
    public void addClothes() {
        getRandomCategory();
        ClothesAddDto clothesAddDto = ClothesAddDto.builder()
                .clothesCategoryType(clothesCategoryEnumType)
                .seasonType(seasonType)
                .price(price)
                .imgUrl(imgUrl)
                .purchasedDate(LocalDate.parse("2020-03-12"))
                .userClosetId(closetId)
                .build();
        Clothes clothes = clothesAddDto.toClothes(clothesAddDto);


        clothesMapper.insertClothes(clothes);


    }


}
