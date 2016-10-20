package com.bonnguyen.tax.test.car;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class CarUnitTest {
    @Test
    public void shouldReturn110IfBefore2002ACarHasAndEngineSizeLessThan1500CC() throws Exception {
        long expected = 110;

        CarInteractorImpl data = new CarInteractorImpl();
        data.setManufactory("Toyota");
        data.setModel("Avensis");
        data.setRegistered(2001);
        data.setEngine(1400);

        long actual = data.calcTax();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturn165IfBefore2002ACarHasAndEngineSizeGreaterThan1500CC() throws Exception {
        long expected = 165;

        CarInteractorImpl data = new CarInteractorImpl();
        data.setManufactory("Toyota");
        data.setModel("Avensis");
        data.setRegistered(2001);
        data.setEngine(1670);

        long actual = data.calcTax();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturn65IfAfter2002ACarHasEmissionUpTo100() throws Exception {
        long expected = 65;

        CarInteractorImpl data = new CarInteractorImpl();
        data.setManufactory("Toyota");
        data.setModel("Avensis");
        data.setRegistered(2002);
        data.setEmission(90);

        long actual = data.calcTax();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturn65IfAfter2002ACarHasEmissionFrom101To120() throws Exception {
        long expected = 75;

        CarInteractorImpl data = new CarInteractorImpl();
        data.setManufactory("Toyota");
        data.setModel("Avensis");
        data.setRegistered(2003);
        data.setEmission(102);

        long actual = data.calcTax();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturn105IfAfter2002ACarHasEmissionFrom121To150() throws Exception {
        long expected = 105;

        CarInteractorImpl data = new CarInteractorImpl();
        data.setManufactory("Toyota");
        data.setModel("Avensis");
        data.setRegistered(2004);
        data.setEmission(123);

        long actual = data.calcTax();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturn125IfAfter2002ACarHasEmissionFrom151To165() throws Exception {
        long expected = 125;

        CarInteractorImpl data = new CarInteractorImpl();
        data.setManufactory("Toyota");
        data.setModel("Avensis");
        data.setRegistered(2005);
        data.setEmission(160);

        long actual = data.calcTax();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturn145IfAfter2002ACarHasEmissionFrom166To185() throws Exception {
        long expected = 145;

        CarInteractorImpl data = new CarInteractorImpl();
        data.setManufactory("Toyota");
        data.setModel("Avensis");
        data.setRegistered(2016);
        data.setEmission(170);

        long actual = data.calcTax();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturn160IfAfter2002ACarHasEmissionOver185() throws Exception {
        long expected = 160;

        CarInteractorImpl data = new CarInteractorImpl();
        data.setManufactory("Toyota");
        data.setModel("Avensis");
        data.setRegistered(2017);
        data.setEmission(200);

        long actual = data.calcTax();
        assertEquals(expected, actual);
    }

}