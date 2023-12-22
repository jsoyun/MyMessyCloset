package com.favorite.project.repository;

import com.favorite.project.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<Users , Long> {
//name을 like 검색한 값을 ID Desc로 Order by하여 2개만 가져오는 메서드를 생성
    List<Users> findFirst2ByUsernameLikeOrderByIDDesc(String name);
}
