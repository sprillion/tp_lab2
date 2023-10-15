package ru.matyuhin.lab2.service;

import org.springframework.stereotype.Service;
import ru.matyuhin.lab2.model.Positions;

import java.util.Calendar;

@Service
public class AnnualBonusServiceImpl implements AnnualBonusService{
    @Override
    public double calculate(Positions position, double salary, double bonus, int workDays) {
        return salary * bonus * countDays() * position.getPositionCoefficient() / workDays;
    }

    private int countDays(){
        return Calendar.getInstance().get(Calendar.YEAR) % 4 == 0 ? 366 : 365;
    }
}
