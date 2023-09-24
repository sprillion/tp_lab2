package ru.matyuhin.lab2.service;

import org.springframework.stereotype.Service;
import ru.matyuhin.lab2.model.Response;

@Service
public interface ModifyResponseService {

    Response modify(Response response);
}
