package ru.matyuhin.lab2.service;

import org.springframework.stereotype.Service;
import ru.matyuhin.lab2.model.Request;

@Service
public interface ModifyRequestService {

    void  modify(Request request);
}
