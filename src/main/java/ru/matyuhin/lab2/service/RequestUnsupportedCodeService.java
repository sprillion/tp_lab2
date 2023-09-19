package ru.matyuhin.lab2.service;

import org.springframework.stereotype.Service;
import ru.matyuhin.lab2.exception.UnsupportedCodeException;
import ru.matyuhin.lab2.model.Request;

import java.util.Objects;

@Service
public class RequestUnsupportedCodeService implements UnsupportedCodeService {

    private static final String  UNSUPPORTED_UID = "123";

    @Override
    public void isSupported(Request request) throws UnsupportedCodeException {
        if (Objects.equals(request.getUid(), UNSUPPORTED_UID)) throw new UnsupportedCodeException();
    }
}
