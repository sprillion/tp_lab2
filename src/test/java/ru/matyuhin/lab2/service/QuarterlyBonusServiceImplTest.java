package ru.matyuhin.lab2.service;

import org.junit.jupiter.api.Test;
import ru.matyuhin.lab2.model.Positions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class QuarterlyBonusServiceImplTest {

    @Test
    void calculate() {
        Positions position = Positions.CEO;
        double bonus = 1.0;
        int workDays = 200;
        double salary = 100000.00;

        double result = new QuarterlyBonusServiceImpl().calculate(position, salary, bonus, workDays);

        double expected = 900000;
        assertThat(result).isEqualTo(expected);
    }
}