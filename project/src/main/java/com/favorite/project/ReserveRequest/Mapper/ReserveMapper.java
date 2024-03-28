package com.favorite.project.ReserveRequest.Mapper;

import com.favorite.project.ReserveRequest.domain.ReserveRequest;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ReserveMapper {

    @Insert("INSERT INTO ReserveRequest(requester_id, board_id, requestTime, requestStatus, amount) VALUES (#{reserveRequest.requesterId},#{reserveRequest.boardId},#{reserveRequest.requestTime},#{reserveRequest.requestStatus}, #{reserveRequest.amount})")
    int createReservationRequest(@Param("reserveRequest") ReserveRequest reserveRequest);
}
