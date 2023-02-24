package com.xiaomizhou.springmvc.exception;

import com.xiaomizhou.common.exception.BadRequestException;
import com.xiaomizhou.common.exception.BusinessCodeException;
import com.xiaomizhou.common.exception.BusinessException;
import com.xiaomizhou.common.exception.NotFoundException;
import com.xiaomizhou.common.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.util.Optional;

/**
 * 全局异常处理
 *
 * @author xiaomizhou
 * @date 2023/2/22
 * @email 521jx123@gmail.com
 */
@RestControllerAdvice
@Slf4j
public class MvcGlobalExceptionHandler {

    /**
     * 默认异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result<String> defaultErrorHandler(Exception e) {
        LOGGER.error("错误", e);
        return Result.error(e);
    }

    /**
     * 方法参数无效异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result<String> defaultErrorHandler(MethodArgumentNotValidException e) {
        LOGGER.error("错误", e);
        String defaultMessage = e.getBindingResult().getAllErrors().stream().iterator().next().getDefaultMessage();
        return Result.<String>builder()
                .code(Result.ResultCode.BAD_REQUEST)
                .message(Result.ResultCode.BAD_REQUEST.getName())
                .data(Optional.ofNullable(defaultMessage))
                .build();
    }

    /**
     * 最大上传限制的错误处理
     *
     * @param e 最大上传限制的异常信息
     * @return 错误结果
     */
    @ExceptionHandler(value = MaxUploadSizeExceededException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result<String> defaultErrorHandler(MaxUploadSizeExceededException e) {
        LOGGER.error("错误", e);
        return Result.error(e);
    }


    /**
     * 对象不存在的错误处理
     *
     * @param e 对象不存在的异常信息
     * @return 错误结果
     */
    @ExceptionHandler(value = NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Result<String> defaultErrorHandler(NotFoundException e) {
        LOGGER.error("错误", e);
        return Result.error(e);
    }

    /**
     * 错误请求的错误处理
     *
     * @param e 错误请求的异常信息
     * @return 错误结果
     */
    @ExceptionHandler(value = BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result<String> defaultErrorHandler(BadRequestException e) {
        LOGGER.error("错误", e);
        return Result.error(e);
    }

    /**
     * 业务逻辑错误的处理
     *
     * @param e 业务逻辑异常信息
     * @return 错误结果
     */
    @ExceptionHandler(value = BusinessException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result<String> defaultErrorHandler(BusinessException e) {
        LOGGER.error("错误", e);
        return Result.error(e);
    }

    /**
     * 带代码的义务逻辑错误处理
     *
     * @param e 代码的义务逻辑异常信息
     * @return 错误结果
     */
    @ExceptionHandler(value = BusinessCodeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result<String> defaultErrorHandler(BusinessCodeException e) {
        LOGGER.error("错误", e);
        return Result.error(e);
    }

}
