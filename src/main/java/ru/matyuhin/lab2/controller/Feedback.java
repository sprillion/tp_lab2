package ru.matyuhin.lab2.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import ru.matyuhin.lab2.model.*;
import ru.matyuhin.lab2.util.DateTimeUtil;

import java.util.Date;

@Slf4j
public class Feedback {

    public static Response CreateResponse(Request request)
    {
        return Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(DateTimeUtil.getCustomFormat().format(new Date()))
                .code(Codes.SUCCESS)
                .errorCode(ErrorCodes.EMPTY)
                .errorMessage(ErrorMessages.EMPTY)
                .build();
    }

    public static ResponseEntity<Response> OnValidationFailedException(Response response, BindingResult bindingResult)
    {
        response.setCode(Codes.FAILED);
        response.setErrorCode(ErrorCodes.VALIDATION_EXCEPTION);
        response.setErrorMessage(ErrorMessages.VALIDATION);
        log.error("{}: {}", ErrorCodes.VALIDATION_EXCEPTION, bindingResult.getFieldError().getDefaultMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    public static ResponseEntity<Response> OnUnsupportedCodeException(Response response)
    {
        response.setCode(Codes.FAILED);
        response.setErrorCode(ErrorCodes.UNSUPPORTED_EXCEPTION);
        response.setErrorMessage(ErrorMessages.UNSUPPORTED);
        log.error(ErrorCodes.UNSUPPORTED_EXCEPTION.toString());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    public static ResponseEntity<Response> OnException(Response response)
    {
        response.setCode(Codes.FAILED);
        response.setErrorCode(ErrorCodes.UNKNOWN_EXCEPTION);
        response.setErrorMessage(ErrorMessages.UNKNOWN);
        log.error(ErrorCodes.UNKNOWN_EXCEPTION.toString());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static ResponseEntity<Response> OnTry(Response response)
    {
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
