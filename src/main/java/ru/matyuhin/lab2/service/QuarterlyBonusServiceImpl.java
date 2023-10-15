package ru.matyuhin.lab2.service;

import org.springframework.stereotype.Service;
import ru.matyuhin.lab2.model.Positions;

@Service
public class QuarterlyBonusServiceImpl implements QuarterlyBonusService{
    @Override
    public double calculate(Positions position, double salary, double bonus, int workDays) {
        if (!position.isManager()) return 0;
        return salary * bonus * 90 * position.getPositionCoefficient() / (workDays / 4);
    }
}
