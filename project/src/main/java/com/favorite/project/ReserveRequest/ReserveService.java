package com.favorite.project.ReserveRequest;

import com.favorite.project.ReserveRequest.Mapper.ReserveMapper;
import com.favorite.project.ReserveRequest.domain.ReserveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.favorite.project.ReserveRequest.ReserveRequestStatus.PENDING;

@Service
@RequiredArgsConstructor
public class ReserveService {

    private final ReserveMapper reserveMapper;

    public void receiveReservationRequest() {
        //예약요청건 DB저장

        ReserveRequest reserveRequest = ReserveRequest.builder()
                .requesterId(1)
                .boardId(24)
                .requestTime(LocalDateTime.now())
                .requestStatus(PENDING)
                .amount(BigDecimal.valueOf(1200))
                .build();


        reserveMapper.createReservationRequest(reserveRequest);


    }

    //


}
