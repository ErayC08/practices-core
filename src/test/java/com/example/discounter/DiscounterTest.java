package com.example.discounter;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiscounterTest {

    @Test
    void shouldApplyChristmasDiscounter() {
        Discounter discounter = Discounter.christmasDiscounter();

        assertEquals(BigDecimal.valueOf(90.0), discounter.applyDiscount(BigDecimal.valueOf(100)));
    }

    @Test
    void shouldApplyEasterDiscounter() {
        Discounter discounter = Discounter.easterDiscounter();

        assertEquals(BigDecimal.valueOf(50.0), discounter.applyDiscount(BigDecimal.valueOf(100)));
    }
}
