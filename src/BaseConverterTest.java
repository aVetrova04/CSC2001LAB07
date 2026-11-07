import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for BaseConverter.
 *
 * These starter tests (with these exact names) should all pass by the
 * time you're done. They are NOT enough on their own - add your own
 * tests (see the TODO list at the bottom and the lab handout).
 */
public class BaseConverterTest {


    // ---- starter tests ----

    @Test
    void convertTest() {
        assertEquals(0, BaseConverter.digitValue('0'));
        assertEquals(3, BaseConverter.digitValue('3'));
        assertEquals(9, BaseConverter.digitValue('9'));
        assertEquals(10, BaseConverter.digitValue('a'));
        assertEquals(35, BaseConverter.digitValue('Z'));
        assertEquals(-1, BaseConverter.digitValue('%'));
        assertEquals(-1, BaseConverter.digitValue('/'));
    }

    @Test
    void toDecimalLectureExamples() {
        assertEquals(45, BaseConverter.toDecimal("101101", 2));
        assertEquals(45, BaseConverter.toDecimal("55", 8));
        assertEquals(45, BaseConverter.toDecimal("2D", 16));
        assertEquals(45, BaseConverter.toDecimal("1200", 3));
        assertEquals(4725, BaseConverter.toDecimal("4725", 10));
    }

    @Test
    void toDecimalLectureStudentMade() {
        assertEquals(0, BaseConverter.toDecimal("0", 2));
        assertEquals(45, BaseConverter.toDecimal("00055", 8));
        assertEquals(45, BaseConverter.toDecimal("2d", 16));
        assertEquals(2, BaseConverter.toDecimal("10", 2));
        assertEquals(36, BaseConverter.toDecimal("10", 36));
        assertThrows(IllegalArgumentException.class, () -> {BaseConverter.toDecimal("11111111111111", 35);});
        assertThrows(IllegalArgumentException.class, () -> {BaseConverter.toDecimal("11111111111111", 36);});
        assertThrows(IllegalArgumentException.class, () -> {BaseConverter.toDecimal("-1", 35);});
        assertThrows(IllegalArgumentException.class, () -> {BaseConverter.toDecimal(null, 36);});
        assertThrows(IllegalArgumentException.class, () -> {BaseConverter.toDecimal("", 36);});
        assertThrows(IllegalArgumentException.class, () -> {BaseConverter.toDecimal("35", 2);});
    }

    @Test
    void toBaseLectureExamples() {
        assertEquals("101101", BaseConverter.toBase(45, 2));
        assertEquals("55", BaseConverter.toBase(45, 8));
        assertEquals("2D", BaseConverter.toBase(45, 16));
        assertEquals("1200", BaseConverter.toBase(45, 3));
        assertEquals("45", BaseConverter.toBase(45, 10));
    }

    @Test
    void toBaseStudentMade() {
        assertEquals("0", BaseConverter.toBase(0, 10));
        assertEquals("9", BaseConverter.toBase(9, 10));
        assertEquals("100", BaseConverter.toBase(256, 16));
        assertEquals("FF", BaseConverter.toBase(255, 16));
        assertEquals("7FFFFFFF", BaseConverter.toBase(Integer.MAX_VALUE, 16));
        assertThrows(IllegalArgumentException.class, () -> {BaseConverter.toBase(-1, 10);});
        assertThrows(IllegalArgumentException.class, () -> {BaseConverter.toBase(45, 1);});
        assertThrows(IllegalArgumentException.class, () -> {BaseConverter.toBase(45, 37);});
    }

    @Test
    void toBaseRecTest() {
        assertEquals("101101", BaseConverter.toBase(45, 2));
        assertEquals("55", BaseConverter.toBase(45, 8));
        assertEquals("2D", BaseConverter.toBase(45, 16));
        assertEquals("1200", BaseConverter.toBase(45, 3));
        assertEquals("45", BaseConverter.toBase(45, 10));
    }

    @Test
    void toBaseRecStudentMade() {
        assertEquals("0", BaseConverter.toBaseRec(0, 10));
        assertEquals("9", BaseConverter.toBaseRec(9, 10));
        assertEquals("100", BaseConverter.toBaseRec(256, 16));
        assertEquals("FF", BaseConverter.toBaseRec(255, 16));
        assertEquals("7FFFFFFF", BaseConverter.toBaseRec(Integer.MAX_VALUE, 16));
        assertThrows(IllegalArgumentException.class, () -> {BaseConverter.toBaseRec(-1, 10);});
        assertThrows(IllegalArgumentException.class, () -> {BaseConverter.toBaseRec(45, 1);});
        assertThrows(IllegalArgumentException.class, () -> {BaseConverter.toBaseRec(45, 37);});
    }


    @Test
    void countDigitsLectureExamples() {
        assertEquals(4, BaseConverter.countDigits(4725, 10));
        assertEquals(6, BaseConverter.countDigits(45, 2));
        assertEquals(2, BaseConverter.countDigits(45, 16));
    }

    @Test
    void countDigitsStudentMade() {
        assertEquals(1, BaseConverter.countDigits(0, 10));
        assertEquals(1, BaseConverter.countDigits(9, 10));
        assertEquals(2, BaseConverter.countDigits(10, 10));
        assertEquals(2, BaseConverter.countDigits(99, 10));
        assertEquals(3, BaseConverter.countDigits(100, 10));
        assertEquals(11, BaseConverter.countDigits(1024, 2));
        assertThrows(IllegalArgumentException.class, () -> {BaseConverter.countDigits(-1, 10);});
        assertThrows(IllegalArgumentException.class, () -> {BaseConverter.countDigits(45, 1);});
        assertThrows(IllegalArgumentException.class, () -> {BaseConverter.countDigits(45, 37);});
    }

    @Test
    void digitCharStudentMade() {
        assertEquals('0', BaseConverter.digitChar(0));
        assertEquals('9', BaseConverter.digitChar(9));
        assertEquals('A', BaseConverter.digitChar(10));
        assertEquals('Z', BaseConverter.digitChar(35));
        assertThrows(IllegalArgumentException.class, () -> {BaseConverter.digitChar(-1);});
        assertThrows(IllegalArgumentException.class, () -> {BaseConverter.digitChar(36);});
    }

    @Test
    void conversionLoopTest() {
        for (int n = 0; n <= 999; n++) {
            for (int base = 2; base <= 36; base++) {
                String converted = BaseConverter.toBase(n, base);
                assertEquals(n, BaseConverter.toDecimal(converted, base));
                assertEquals(Integer.toString(n, base).toUpperCase(), converted);
                assertEquals(converted, BaseConverter.toBaseRec(n, base));
            }
        }
    }
}
