package com.example.table;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ColorTableTest {

    @Test
    void givenRowsAndColumnsWithDistinctValues_whenConstructInstance_thenReturnInstance() {
        final int rows = 6;
        final int columns = 7;

        ColorTable colorTable = new ColorTable(rows, columns);

        boolean colorIsPresent = false;
        for (int i = 0; i < colorTable.getRows(); i++) {
            for (int j = 0; j < colorTable.getColumns(); j++) {
                if (colorTable.getColor(i + 1, j + 1).isPresent()) {
                    colorIsPresent = true;
                    break;
                }
            }
        }
        Assertions.assertFalse(colorIsPresent);
    }

    @Test
    void givenInvalidRowNumOrColNum_whenGetColor_thenReturnNull() {
        final int invalidRowNum = -1;
        final int colNum = 2;

        Assertions.assertNull(new ColorTable(6, 7).getColor(invalidRowNum, colNum));
    }

    @Test
    void givenValidRowNumAndColNum_whenGetColor_thenReturnColor() {
        final int validRowNum = 1;
        final int validColNum = 2;

        Assertions.assertEquals(Color.NONE, new ColorTable(6, 7).getColor(validRowNum, validColNum));
    }

    @Test
    void givenAnInvalidColorInstanceAndValidRowAndColumnNumbers_whenSetColor_thenThrowInvalidColorException() {
        final Color color = Color.NONE;
        final int validRowNum = 1;
        final int validColNum = 2;

        Assertions.assertThrows(InvalidColorException.class, () -> new ColorTable(6, 7)
                .setColor(validRowNum, validColNum, color));
    }

    @Test
    void givenAValidColorInstanceAndInvalidRowOrColumnNumbers_whenSetColor_thenThrowInvalidRowOrColumnNumberException() {
        final Color color = Color.RED;
        final int invalidRowNum = -1;
        final int validColNum = 2;

        Assertions.assertThrows(InvalidRowOrColumnNumberException.class, () -> new ColorTable(6, 7)
                .setColor(invalidRowNum, validColNum, color));
    }

    @Test
    void givenAValidColorInstanceAndValidRowAndColumnNumbers_whenSetColor_thenSetColorAsExpected() {
        final Color color = Color.RED;
        final int validRowNum = 1;
        final int validColNum = 2;

        ColorTable colorTable = new ColorTable(6, 7);

        colorTable.setColor(validRowNum, validColNum, color);

        Assertions.assertEquals(Color.RED, colorTable.getColor(validRowNum, validColNum));
    }
}
