package ru.matyuhin.lab2.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.matyuhin.lab2.exception.ValidationFailedException;

@Service
public interface ValidationService {
    void isValid(BindingResult bindingResult) throws ValidationFailedException;
}
