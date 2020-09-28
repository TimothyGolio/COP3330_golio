import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BodyMassIndexTest {

    private BodyMassIndex BMI;

    @Test
    public void testGetBodyMassIndex() {
        BMI = new BodyMassIndex(40, 80);
        double answer = BMI.getBodyMassIndex();
        assertEquals(35.15, answer);

    }

    @Test
    public void testGetBodyMassIndexTwoLargeValues() {
        BMI = new BodyMassIndex(400000000, 800000000);
        double answer = BMI.getBodyMassIndex();
        assertEquals(0.000003515, answer);
    }

    @Test
    public void testGetBodyMassIndexTwoNegativeValues() {
        BMI = new BodyMassIndex(-1, -1);
        double answer = BMI.getBodyMassIndex();
        assertEquals(-703, answer);
    }

    @Test
    public void testGetBodyMassIndexOneLargeNegativeValue() {
        BMI = new BodyMassIndex(-1, -196);
        double answer = BMI.getBodyMassIndex();
        assertEquals(-137788, answer);
    }

    @Test
    public void testGetBodyMassIndexFirstNegative() {
        BMI = new BodyMassIndex(-1, 1);
        double answer = BMI.getBodyMassIndex();
        assertEquals(703, answer);
    }

    @Test
    public void testGetBodyMassIndexSecondNegative() {
        BMI = new BodyMassIndex(1, -1);
        double answer = BMI.getBodyMassIndex();
        assertEquals(-703, answer);
    }

    @Test
    public void testGetBodyMassCategoryUnderweight() {
        BMI = new BodyMassIndex(69, 40);
        String answer = BMI.getBodyMassCategory();
        assertEquals("Underweight", answer);
    }

    @Test
    public void testGetBodyMassCategoryUnderweightNegative() {
        BMI = new BodyMassIndex(5, -3);
        String answer = BMI.getBodyMassCategory();
        assertEquals("Underweight", answer);
    }

    @Test
    public void testGetBodyMassCategoryNormalWeight() {
        BMI = new BodyMassIndex(69, 160);
        String answer = BMI.getBodyMassCategory();
        assertEquals("Normal weight", answer);
    }

    @Test
    public void testGetBodyMassCategoryOverweight() {
        BMI = new BodyMassIndex(69, 190);
        String answer = BMI.getBodyMassCategory();
        assertEquals("Overweight", answer);
    }

    @Test
    public void testGetBodyMassCategoryObese() {
        BMI = new BodyMassIndex(69, 40000);
        String answer = BMI.getBodyMassCategory();
        assertEquals("Obesity", answer);
    }

}