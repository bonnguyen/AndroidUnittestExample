package com.bonnguyen.tax.test;

import com.bonnguyen.tax.test.car.CarUnitTest;
import com.bonnguyen.tax.test.van.VanUnitTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(Suite.class)
@SuiteClasses({
        CarUnitTest.class,
        VanUnitTest.class})
public class AllTests {

}