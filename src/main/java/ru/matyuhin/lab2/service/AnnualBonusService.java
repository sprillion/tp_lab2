package ru.matyuhin.lab2.service;

import org.springframework.stereotype.Service;
import ru.matyuhin.lab2.model.Positions;

@Service
public interface AnnualBonusService {

    double calculate(Positions position, double salary, double bonus, int workDays);
}
