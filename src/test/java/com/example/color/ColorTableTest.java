package com.example.color;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ColorTableTest {

    @Test
    void whenConstructColorTableInstance_thenSuccessful() {
        final int rows = 6;
        final int columns = 8;

        ColorTable colorTable = new ColorTable(rows, columns);

        boolean isNone = true;
        for (int i = 0; i < colorTable.getRows(); i++) {
            for (int j = 0; j < colorTable.getColumns(); j++) {
                if (!colorTable.getColor(i, j).isNone()) {
                    isNone = false;
                    break;
                }
            }
        }
        Assertions.assertTrue(isNone);
    }

    @Test
    void givenInvalidRowIndex_whenGetColor_thenReturnNull() {
        final int invalidRowIndex = -1;
        final int columnIndex = 2;

        Assertions.assertNull(new ColorTable(6, 8).getColor(invalidRowIndex, columnIndex));
    }

    @Test
    void givenValidIndexes_whenGetColor_thenReturnColor() {
        final int rowIndex = 1;
        final int columnIndex = 2;

        Assertions.assertEquals(Color.NONE, new ColorTable(6, 8).getColor(rowIndex, columnIndex));
    }

    @Test
    void givenInvalidColorInstance_whenSetColor_thenThrowInvalidColorException() {
        final Color color = Color.NONE;

        Assertions.assertThrows(InvalidColorException.class,
                () -> new ColorTable(6, 8).setColor(1, 2, color));
    }
}
