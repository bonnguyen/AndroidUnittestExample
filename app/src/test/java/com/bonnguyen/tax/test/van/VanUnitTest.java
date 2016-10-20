package com.bonnguyen.tax.test.van;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class VanUnitTest {
    @Test
    public void shouldReturn165IfAVanHasWeightLessThan3500() throws Exception {
        long expected = 165;

        VanInteractorImpl data = new VanInteractorImpl();
        data.setManufactory("Toyota");
        data.setModel("Avensis");
        data.setRegistered(2001);
        data.setWeight(3000);

        long actual = data.calcTax();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturn190IfAVanHasWeightGreaterThan3500() throws Exception {
        long expected = 190;

        VanInteractorImpl data = new VanInteractorImpl();
        data.setManufactory("Toyota");
        data.setModel("Avensis");
        data.setRegistered(2001);
        data.setWeight(4000);

        long actual = data.calcTax();
        assertEquals(expected, actual);
    }
}