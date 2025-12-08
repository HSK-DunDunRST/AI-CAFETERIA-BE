package com.hsk.cafeteria.apiPayload.code.status;

import com.hsk.cafeteria.apiPayload.code.BaseErrorCode;
import com.hsk.cafeteria.apiPayload.code.ErrorReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorType implements BaseErrorCode {
    // 에러 예시
    FAIL_OOOOO(HttpStatus.BAD_REQUEST, "FAIL", "실패하였습니다."),

    // 일반적인 응답
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST,"COMMON400","잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED,"COMMON401","인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),
    RESOURCE_NOT_FOUND(HttpStatus.NOT_FOUND, "RESOURCE404", "리소스를 찾을 수 없습니다."),
    MISSING_FILED_ERROR(HttpStatus.NOT_IMPLEMENTED, "FIELD501", "필수 파라미터가 누락되었어요."),

    // 공지사항 조회
    NOT_FOUND_NOTICE_DATA(HttpStatus.NOT_FOUND, "NOTICE404", "불러올 공지사항이 없어요."),

    // 식당정보 조회
    NOT_FOUND_CAFETERIA_DATA(HttpStatus.NOT_FOUND, "NOTICE404", "불러올 식당정보가 없어요."),

    // 혼잡도 조회
    NOT_FOUND_CONGESTION_DATA(HttpStatus.NOT_FOUND, "NOTICE404", "불러올 혼잡도 데이터가 없어요.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build();
    }
}
