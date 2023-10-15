package ru.matyuhin.lab2.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.matyuhin.lab2.exception.UnsupportedCodeException;
import ru.matyuhin.lab2.exception.ValidationFailedException;
import ru.matyuhin.lab2.model.*;
import ru.matyuhin.lab2.service.*;

import javax.validation.Valid;

@Slf4j
@RestController
public class MyController {

    private final ValidationService validationService;
    private final UnsupportedCodeService unsupportedCodeService;
    private final ModifyResponseService modifyResponseService;
    private final ModifyRequestService modifyRequestService;

    @Autowired
    public MyController(ValidationService validationService,
                        UnsupportedCodeService unsupportedCodeService,
                        @Qualifier("ModifySystemTimeResponseService") ModifyResponseService modifyResponseService,
                        @Qualifier("ModifySystemTimeRequestService") ModifyRequestService modifyRequestService){

        this.validationService = validationService;
        this.unsupportedCodeService = unsupportedCodeService;
        this.modifyResponseService = modifyResponseService;
        this.modifyRequestService = modifyRequestService;
    }

    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@Valid @RequestBody Request request, BindingResult bindingResult) {

        modifyRequestService.modify(request);
        log.info("request: {}", request);
        Response response = Feedback.CreateResponse(request);
        log.info("response: {}", response);

        try {
            validationService.isValid(bindingResult);
            unsupportedCodeService.isSupported(request);
        } catch (ValidationFailedException e){
            return Feedback.OnValidationFailedException(response, bindingResult);
        } catch (UnsupportedCodeException e){
            return Feedback.OnUnsupportedCodeException(response);
        } catch (Exception e){
            return Feedback.OnException(response);
        }
        return Feedback.OnTry(response);
    }
}