package com.xiaomizhou.common.vo;

import com.xiaomizhou.common.entity.ValueNameEnum;
import com.xiaomizhou.common.utils.ValueNameEnumUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

/**
 * @author xiaomizhou
 * @date 2023/2/20 21:25
 * @email 521jx123@gmail.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Result<T> {

    private ResultCode code;
    private String message;
    private Optional<T> data;

    public static Result<Void> success() {
        return Result.<Void>builder()
                .code(ResultCode.SUCCESS)
                .message(ResultCode.SUCCESS.getName())
                .build();
    }

    public static <T> Result<T> success(T data) {
        return Result.<T>builder()
                .code(ResultCode.SUCCESS)
                .message(ResultCode.SUCCESS.getName())
                .data(Optional.ofNullable(data))
                .build();
    }

    public static Result<Void> of(ResultCode code) {
        return Result.<Void>builder()
                .code(code)
                .message(code.getName())
                .build();
    }

    public static <T> Result<T> of(ResultCode code, T data) {
        return Result.<T>builder()
                .code(code)
                .message(code.getName())
                .data(Optional.ofNullable(data))
                .build();
    }

    public static Result<String> error(Throwable e) {
        return Result.<String>builder()
                .code(ResultCode.INTERNAL_SERVER_ERROR)
                .message(ResultCode.INTERNAL_SERVER_ERROR.getName())
                .data(Optional.ofNullable(e.getMessage()))
                .build();
    }

    public static Result<String> error(ResultCode code, Exception e) {
        return Result.<String>builder()
                .code(code)
                .message(code.getName())
                .data(Optional.ofNullable(e.getMessage()))
                .build();
    }


    public enum ResultCode implements ValueNameEnum {
        /**
         * ??????
         */
        SUCCESS(200, "??????"),
        /**
         * ????????????
         */
        BAD_REQUEST(400, "????????????"),
        /**
         * ?????????
         */
        UNAUTHORIZED(401, "?????????"),
        /**
         * ????????????
         */
        FORBIDDEN(403, "????????????"),
        /**
         * ???????????????
         */
        NOT_FOUND(404, "???????????????"),
        /**
         * ????????????
         */
        REQUEST_TIMEOUT(408, "????????????"),
        /**
         /**
         * ????????????
         */
        TOO_MANY_REQUESTS(429, "????????????"),
        /**
         * ?????????????????????
         */
        INTERNAL_SERVER_ERROR(500, "??????????????????"),
        /**
         * ???????????????
         */
        SERVICE_UNAVAILABLE(503, "???????????????");

        private final int value;
        private final String name;

        ResultCode(int value, String name) {
            this.value = value;
            this.name = name;
        }

        @Override
        public int getValue() {
            return value;
        }

        @Override
        public String getName() {
            return name;
        }

        public static ResultCode valueOf(int value) {
            return ValueNameEnumUtils.valueOf(ResultCode.class, value);
        }
    }
}
