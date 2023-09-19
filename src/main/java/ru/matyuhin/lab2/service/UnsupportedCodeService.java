package ru.matyuhin.lab2.service;

import org.springframework.stereotype.Service;
import ru.matyuhin.lab2.exception.UnsupportedCodeException;
import ru.matyuhin.lab2.model.Request;

@Service
public interface UnsupportedCodeService {
    void isSupported(Request request) throws UnsupportedCodeException;
}
