package com.favorite.project.ReserveRequest;

import lombok.Getter;

@Getter
public enum ReserveRequestStatus {
    PENDING("요청대기중"),
    APPROVED("승인"),
    REJECTED("거부");

    private String status;
    
    ReserveRequestStatus(String status) {
        this.status = status;
    }
}
