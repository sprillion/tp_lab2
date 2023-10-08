package ru.matyuhin.lab2.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.matyuhin.lab2.model.Request;
import ru.matyuhin.lab2.model.Systems;

@Service
@Qualifier("ModifySystemNameService")
public class ModifySystemNameService implements ModifyRequestService {

    private static final String URL = "http://localhost:8084/feedback";

    @Override
    public void modify(Request request) {
        request.setSystemName(Systems.SERVICE_1);

        HttpEntity<Request> httpEntity = new HttpEntity<>(request);

        new RestTemplate().exchange(
                URL,
                HttpMethod.POST,
                httpEntity,
                new ParameterizedTypeReference<>(){
                });
    }
}