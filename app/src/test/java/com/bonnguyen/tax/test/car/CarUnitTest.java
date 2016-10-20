package com.bonnguyen.tax.test.car;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class CarUnitTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldReturn110IfBefore2002ACarHasAndEngineSizeLessThan1500CC() {
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
    public void shouldReturn165IfBefore2002ACarHasAndEngineSizeGreaterThan1500CC() {
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
    public void shouldReturn65IfAfter2002ACarHasEmissionUpTo100() {
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
    public void shouldReturn65IfAfter2002ACarHasEmissionFrom101To120() {
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
    public void shouldReturn105IfAfter2002ACarHasEmissionFrom121To150() {
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
    public void shouldReturn125IfAfter2002ACarHasEmissionFrom151To165() {
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
    public void shouldReturn145IfAfter2002ACarHasEmissionFrom166To185() {
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
    public void shouldReturn160IfAfter2002ACarHasEmissionOver185() {
        long expected = 160;

        CarInteractorImpl data = new CarInteractorImpl();
        data.setManufactory("Toyota");
        data.setModel("Avensis");
        data.setRegistered(2017);
        data.setEmission(200);

        long actual = data.calcTax();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnExceptionIfRegisteredACarLessThan0() {
        CarInteractorImpl data = new CarInteractorImpl();
        data.setManufactory("Toyota");
        data.setModel("Avensis");
        data.setRegistered(-1);
        data.setEmission(200);

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Registered of car should be greater than 0");
        data.calcTax();
    }

    @Test
    public void shouldReturnExceptionIfEngineACarLessThan0() {
        CarInteractorImpl data = new CarInteractorImpl();
        data.setManufactory("Toyota");
        data.setModel("Avensis");
        data.setRegistered(2001);
        data.setEngine(-1);

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Engine of car should be greater than 0");
        data.calcTax();
    }

    @Test
    public void shouldReturnExceptionIfEmissionACarLessThan0() {
        CarInteractorImpl data = new CarInteractorImpl();
        data.setManufactory("Toyota");
        data.setModel("Avensis");
        data.setRegistered(2007);
        data.setEmission(-1);

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Emission of car should be greater than 0");
        data.calcTax();
    }

}